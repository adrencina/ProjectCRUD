package com.example.projectcrud.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectcrud.R
import com.example.projectcrud.databinding.ItemRvHomeBinding
import com.example.projectcrud.model.Product
import com.squareup.picasso.Picasso

class ProductAdapter(var products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemRvHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int = products.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateProducts(newProducts: List<Product>) {
        products = newProducts
        notifyDataSetChanged()
    }

    class ProductViewHolder(private val binding: ItemRvHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.textCard.text = product.name
            binding.priceCard.text = product.price
            binding.descriptionCard.text = product.description
            binding.idCard.text = product.id.toString()

            // Cargar con Picasso
            val imageUrl = product.images.firstOrNull()
            if (!imageUrl.isNullOrEmpty()) {
                Picasso.get().load(imageUrl).into(binding.imgCard)
            } else {
                binding.imgCard.setImageResource(R.drawable.ic_launcher_background)
            }
        }
    }
}




//import android.annotation.SuppressLint
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.projectcrud.databinding.ItemRvHomeBinding
//import com.example.projectcrud.model.Product
//
//import com.squareup.picasso.Picasso
//
//class ProductAdapter(var products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
//        val binding = ItemRvHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ProductViewHolder(binding)
//    }
//
//
//
//
//
//    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
//        holder.bind(products[position])
//    }
//
//
//
//
//
//
//
//
//
//    override fun getItemCount(): Int = products.size
//
//    @SuppressLint("NotifyDataSetChanged")
//    fun updateProducts(newProducts: List<Product>) {
//        products = newProducts
//        notifyDataSetChanged()
//    }
//    class ProductViewHolder(private val binding: ItemRvHomeBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(product: Product) {
//            binding.textCard.text = product.name
//            binding.priceCard.text = product.price
//            binding.descriptionCard.text = product.description
//            binding.idCard.text = product.id.toString()
//
//            product.images
//
//            Picasso.get().load(product.images.firstOrNull()).into(binding.imgCard)
//        }
//    }
//}



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