package com.example.projectcrud.repository

import com.example.projectcrud.model.Product

object ProductRepository {
    private val products = mutableListOf<Product>()

    fun getAllProducts(): List<Product> = products

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

    fun deleteProduct(id: Int): Boolean {
        val initialSize = products.size
        products.removeAll { it.id == id }
        return products.size < initialSize
    }

    fun searchProducts(query: String): List<Product> {
        return products.filter {
            it.name.contains(query, true) || it.id.toString() == query
        }
    }

}