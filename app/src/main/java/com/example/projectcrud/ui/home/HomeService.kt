package com.example.projectcrud.ui.home

import retrofit2.Response
import retrofit2.http.GET

interface HomeService {
    @GET("/products")

    suspend fun getProducts(): Response<ProductResponse>
}