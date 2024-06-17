package com.example.mymaps.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymaps.R
import com.example.mymaps.data.model.ProductsResponseItem
import com.example.mymaps.databinding.ListItemProductBinding

class ProductsAdapter :
    ListAdapter<ProductsResponseItem, ProductsAdapter.ViewHolder>(DiffUtilCallback) {
    inner class ViewHolder constructor(private val binding: ListItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(imageUrl: String?, prodName: String?) {
            binding.tvProdName.text = prodName
            Glide.with(binding.root)
                .load(imageUrl)
                .into(binding.ivProduct)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ListItemProductBinding>(
            LayoutInflater.from(parent.context),
            R.layout.list_item_product,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item.image, item.title)
    }
}

object DiffUtilCallback : DiffUtil.ItemCallback<ProductsResponseItem>() {
    override fun areItemsTheSame(
        oldItem: ProductsResponseItem,
        newItem: ProductsResponseItem
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: ProductsResponseItem,
        newItem: ProductsResponseItem
    ): Boolean {
        return oldItem == newItem
    }

}