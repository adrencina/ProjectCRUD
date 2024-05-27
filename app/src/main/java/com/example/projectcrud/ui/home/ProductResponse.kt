package com.example.projectcrud.ui.home

import com.google.gson.annotations.SerializedName

data class ProductResponse(

    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("images")
    val images: String,
)
