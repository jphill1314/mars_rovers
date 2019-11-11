package com.jphill.marsrovers.latestphotos

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.jphill.marsrovers.R
import com.jphill.marsrovers.databinding.FragmentLatestPhotosBinding
import com.jphill.marsrovers.latestphotos.rv.LatestPhotosAdapter
import com.jphill.marsrovers.latestphotos.vm.LatestPhotosFactory
import com.jphill.marsrovers.latestphotos.vm.LatestPhotosViewModel
import com.jphill.retrofit.models.Photo
import com.jphill.retrofit.rovers.asInt
import com.jphill.retrofit.rovers.toRover
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
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.filters, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.choose_camera -> {
                val items = arrayListOf<String>()
                items.add("Any camera")
                items.addAll(viewModel?.rover?.cameras?.map { it.second } ?: emptyList())
                AlertDialog.Builder(context)
                    .setTitle("Choose camera")
                    .setItems(items.toTypedArray()) { _, which ->
                        viewModel?.changeCamera(which - 1)
                    }
                    .show()
            }
            R.id.choose_rover -> {
                AlertDialog.Builder(context)
                    .setTitle("Choose rover")
                    .setItems(arrayOf(
                        resources.getString(R.string.curiosity),
                        resources.getString(R.string.opportunity),
                        resources.getString(R.string.spirit)
                    )) { _, which -> viewModel?.changeRover(which) }
                    .show()
            }
        }
        return super.onOptionsItemSelected(item)
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(LatestPhotosViewModel::class.java).apply {
            savedInstanceState?.let {
                selectedCamera = it.getInt(CAMERA, -1)
                changeRover(it.getInt(ROVER, 1))
            } ?: getRoverAndPhotos()
        }
        viewModel?.photosFromSol?.observe(this, Observer<List<Photo>> {
            adapter?.onNewData(it)
        })
    }

    override fun onDestroyView() {
        binding = null
        adapter?.fragment = null
        super.onDestroyView()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ROVER, viewModel?.rover?.asInt() ?: 1)
        outState.putInt(CAMERA, viewModel?.selectedCamera ?: -1)
    }

    private companion object {
        const val ROVER = "rover"
        const val CAMERA = "camera"
    }
}