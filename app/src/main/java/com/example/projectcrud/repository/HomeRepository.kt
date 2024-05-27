package com.example.projectcrud.repository

import com.example.projectcrud.ui.home.HomeServiceImp
import com.example.projectcrud.ui.home.ProductResponse
import retrofit2.Response

class HomeRepository(private val service: HomeServiceImp = HomeServiceImp()) {
    suspend fun getProducts(): List<ProductResponse> {
        return service.getProducts()
    }
}