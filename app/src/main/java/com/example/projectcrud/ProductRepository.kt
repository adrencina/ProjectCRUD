package com.example.projectcrud

//class ProductRepository {
    object ProductRepository {
        private val products = mutableListOf<Product>()

        fun addProduct(product: Product) {
            products.add(product)
        }

        fun deleteProduct(productName: String): Boolean {
            val product = products.find { it.name == productName }
            return if (product != null) {
                products.remove(product)
                true
            } else {
                false
            }
        }

    fun getProducts(): List<Product> {
        return products
    }
}


//}


