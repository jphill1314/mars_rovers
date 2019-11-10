package com.jphill.marsrovers.latestphotos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jphill.marsrovers.databinding.ListItemSquareImageBinding
import com.jphill.retrofit.models.PhotosOnSolResponse

class LatestPhotosAdapter(
    var fragment: Fragment? = null
) : RecyclerView.Adapter<LatestPhotosAdapter.ViewHolder>() {

    var photos: PhotosOnSolResponse? = null
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ListItemSquareImageBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ListItemSquareImageBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = photos?.photos?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        photos?.photos?.get(position)?.let { image ->
            fragment?.let {
                Glide.with(it).load(image.src).into(holder.binding.image)
            }
        }
    }
}