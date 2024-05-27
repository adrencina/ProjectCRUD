package com.example.projectcrud.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectcrud.R
import com.example.projectcrud.databinding.ItemRvHomeBinding
import com.squareup.picasso.Picasso

class ProductAdapter(private var products: List<ProductResponse>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemRvHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int = products.size

    fun updateProducts(newProducts: List<ProductResponse>) {
        products = newProducts
        notifyDataSetChanged()
    }
    class ProductViewHolder(private val binding: ItemRvHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductResponse) {
            binding.textCard.text = product.name
            binding.priceCard.text = product.price.toString()
            binding.descriptionCard.text = product.description
            binding.idCard.text = product.id.toString()

            val images = product.images

            Picasso.get().load(images).into(binding.imgCard)
        }
    }
}


//
//    fun updateProducts(newProducts: List<Product>) {
//        products.clear()
//        products.addAll(newProducts)
//        notifyDataSetChanged()
//    }

//    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//
//        private val binding = ItemRvHomeBinding.bind(view)
//
//        fun render(value: String){
//            Picasso.get().load(value).into(binding.imgCard)
//
//        }
//    }