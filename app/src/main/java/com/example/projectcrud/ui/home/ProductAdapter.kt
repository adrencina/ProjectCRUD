package com.example.projectcrud.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectcrud.R
import com.example.projectcrud.databinding.ItemRvHomeBinding
import com.example.projectcrud.model.Product
import com.squareup.picasso.Picasso

class ProductAdapter(private val productList: List<String>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private val products = mutableListOf<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_home,parent,false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.render(productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun updateProducts(newProducts: List<Product>) {
        products.clear()
        products.addAll(newProducts)
        notifyDataSetChanged()
    }

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemRvHomeBinding.bind(view)

        fun render(value: String){
            Picasso.get().load(value).into(binding.imgHome)

        }
    }
}