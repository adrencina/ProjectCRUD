package com.example.projectcrud.model

// Clase de datos para representar productos
data class Product (
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val imageUrl: String = ""
)