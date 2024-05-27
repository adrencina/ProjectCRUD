package com.example.projectcrud.ui.home

import com.google.gson.annotations.SerializedName

data class ProductResponse(

    @SerializedName("message")
    val message: List<String>?,

    @SerializedName("status")
    val status: String?
)

