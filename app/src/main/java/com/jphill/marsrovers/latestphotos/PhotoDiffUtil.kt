package com.jphill.marsrovers.latestphotos

import androidx.recyclerview.widget.DiffUtil
import com.jphill.retrofit.models.Photo

class PhotoDiffUtil(
    private val oldList: List<Photo>,
    private val newList: List<Photo>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}