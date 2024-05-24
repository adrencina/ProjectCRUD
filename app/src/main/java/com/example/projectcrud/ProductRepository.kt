package com.example.projectcrud

class ProductRepository {
    private val products = mutableListOf<Product>()

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