package com.example.projectcrud.model

// Clase de datos para representar productos
data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: String,
    val images: List<String>
)