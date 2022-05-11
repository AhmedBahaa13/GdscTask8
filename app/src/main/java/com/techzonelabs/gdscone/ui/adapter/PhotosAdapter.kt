package com.techzonelabs.gdscone.ui.adapter

import android.R
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.techzonelabs.gdscone.data.models.PhotoModel
import com.techzonelabs.gdscone.databinding.PhotoItemBinding


class PhotosAdapter() : RecyclerView.Adapter<PhotosAdapter.PhotosHolder>() {
    private var list = emptyList<PhotoModel>()

    class PhotosHolder(val binding: PhotoItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosHolder {
        val binding = PhotoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotosHolder(binding)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: PhotosHolder, position: Int) {
        Picasso.get().load(list[position].url)
            .placeholder(R.drawable.screen_background_dark).into(holder.binding.imageView)
        holder.binding.textView.text = list[position].title
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setList(newList: List<PhotoModel>) {
        this.list = newList
        notifyDataSetChanged()
    }
}