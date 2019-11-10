package com.jphill.marsrovers.latestphotos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jphill.marsrovers.databinding.ListItemSquareImageBinding
import com.jphill.retrofit.models.LatestImagesResponse

class LatestPhotosAdapter : RecyclerView.Adapter<LatestPhotosAdapter.ViewHolder>() {

    var latestPhotos: LatestImagesResponse? = null
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ListItemSquareImageBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ListItemSquareImageBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = latestPhotos?.latestPhotos?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        latestPhotos?.latestPhotos?.get(position)?.let { image ->
            Glide.with(holder.itemView.context).load(image.src).into(holder.binding.image)
        }
    }
}