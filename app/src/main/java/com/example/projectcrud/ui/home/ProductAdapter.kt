package com.example.projectcrud.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.projectcrud.R
import com.example.projectcrud.databinding.ItemRvHomeBinding
import com.example.projectcrud.model.Product
import com.squareup.picasso.Picasso

class ProductAdapter : ListAdapter<ProductResponse, ProductAdapter.ProductViewHolder>(ProductDiffCallback()) {

    private val productList = mutableListOf<ProductResponse>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemRvHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.bind(product)
    }

    fun setList(products: List<ProductResponse>) {
        productList.clear()
        productList.addAll(products)
        notifyDataSetChanged()
    }

    class ProductViewHolder(private val binding: ItemRvHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductResponse) {
            binding.idCard.text = product.id.toString()
            binding.textCard.text = product.title
            binding.descriptionCard.text = product.description
            Picasso.get().load(product.images.firstOrNull())
                .into(binding.imgCard)
        }
    }

    class ProductDiffCallback : DiffUtil.ItemCallback<ProductResponse>() {
        override fun areItemsTheSame(oldItem: ProductResponse, newItem: ProductResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductResponse, newItem: ProductResponse): Boolean {
            return oldItem == newItem
        }
    }
}
