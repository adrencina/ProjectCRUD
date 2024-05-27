package com.example.projectcrud.repository

import com.example.projectcrud.ui.home.ProductResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.projectcrud.ui.home.HomeService


class HomeRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.escuelajs.co/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(HomeService::class.java)

    suspend fun getProducts(): Response<List<ProductResponse>> {
        return service.getProducts()
    }
}
