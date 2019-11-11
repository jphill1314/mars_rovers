package com.jphill.marsrovers.latestphotos.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jphill.marsrovers.databinding.ListItemSquareImageBinding
import com.jphill.retrofit.models.Photo

class LatestPhotosAdapter(
    var fragment: Fragment? = null,
    private val loadMoreImages: () -> Unit
) : RecyclerView.Adapter<LatestPhotosAdapter.ViewHolder>() {
    private var photos: List<Photo>? = null

    fun onNewData(newList: List<Photo>) {
        val diffResult = DiffUtil.calculateDiff(
            PhotoDiffUtil(
                photos ?: emptyList(),
                newList
            )
        )
        diffResult.dispatchUpdatesTo(this)
        photos = newList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ListItemSquareImageBinding.inflate(inflater, parent, false)
        )
    }

    override fun getItemCount(): Int = photos?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        photos?.get(position)?.let { image ->
            fragment?.let {
                Glide.with(it).load(image.src).into(holder.binding.image)
            }
        }
        if (itemCount != 0 && position == itemCount - 1) {
            loadMoreImages()
        }
    }

    class ViewHolder(val binding: ListItemSquareImageBinding): RecyclerView.ViewHolder(binding.root)
}
