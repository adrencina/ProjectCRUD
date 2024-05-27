package com.example.projectcrud.repository

import com.example.projectcrud.model.Product

class ProductRepository {
    private val products = mutableListOf<Product>()

    fun getProducts(): List<Product> {
        return products
    }

    fun getProductById(id: Int): Product? {
        return products.find { it.id == id }
    }

    fun addProduct(product: Product) {
        products.add(product)
    }

    fun updateProduct(product: Product) {
        val index = products.indexOfFirst { it.id == product.id }
        if (index != -1) {
            products[index] = product
        }
    }

    fun deleteProduct(id: Int) {
        products.removeAll { it.id == id }
    }

}