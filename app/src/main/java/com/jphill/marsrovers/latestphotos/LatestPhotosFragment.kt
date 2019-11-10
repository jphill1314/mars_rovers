package com.jphill.marsrovers.latestphotos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jphill.marsrovers.databinding.FragmentLatestPhotosBinding
import com.jphill.retrofit.models.LatestImagesResponse
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class LatestPhotosFragment : Fragment() {

    private var binding: FragmentLatestPhotosBinding? = null
    private var adapter: LatestPhotosAdapter? = null
    private var viewModel: LatestPhotosViewModel? = null
    @Inject
    lateinit var factory: LatestPhotosFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLatestPhotosBinding.inflate(inflater, container, false).also {
            adapter = LatestPhotosAdapter()
            it.recyclerView.adapter = adapter
            it.recyclerView.layoutManager = LinearLayoutManager(context)
        }
        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        viewModel = ViewModelProviders.of(this, factory).get(LatestPhotosViewModel::class.java)
        viewModel?.latestPhotos?.observe(this, Observer<LatestImagesResponse> {
            updateView(it)
        })
    }

    private fun updateView(latestPhotos: LatestImagesResponse) {
        adapter?.latestPhotos = latestPhotos
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}