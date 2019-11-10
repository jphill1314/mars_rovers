package com.jphill.marsrovers.latestphotos

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.jphill.marsrovers.databinding.FragmentLatestPhotosBinding
import com.jphill.retrofit.models.Photo
import com.jphill.retrofit.models.PhotosOnSolResponse
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class LatestPhotosFragment : Fragment() {

    private var binding: FragmentLatestPhotosBinding? = null
    private var adapter: LatestPhotosAdapter? = null
    private var viewModel: LatestPhotosViewModel? = null
    @Inject
    lateinit var factory: LatestPhotosFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLatestPhotosBinding.inflate(inflater, container, false).also {
            adapter = LatestPhotosAdapter(this) { viewModel?.getMorePhotos() }
            it.recyclerView.adapter = adapter
            it.recyclerView.layoutManager = GridLayoutManager(context, 2)
        }
        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        viewModel = ViewModelProviders.of(this, factory).get(LatestPhotosViewModel::class.java)
        viewModel?.photosFromSol?.observe(this, Observer<List<Photo>> {
            adapter?.onNewData(it)
        })
    }

    override fun onDestroyView() {
        binding = null
        adapter?.fragment = null
        super.onDestroyView()
    }
}