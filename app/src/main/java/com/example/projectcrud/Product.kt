package com.example.projectcrud

// Clase de datos para representar productos
data class Product (
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: String
)