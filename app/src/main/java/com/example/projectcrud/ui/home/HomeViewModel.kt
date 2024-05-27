package com.example.projectcrud.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import com.example.projectcrud.model.Product
import kotlinx.coroutines.launch
import java.io.IOException
import com.example.projectcrud.repository.HomeRepository

class HomeViewModel(private val repository: HomeRepository = HomeRepository()) : ViewModel() {

    //private val _text = MutableLiveData<String>().apply {
        //value = "This is home Fragment"
    //}
    //val text: LiveData<String> = _text

    private val _products = MutableLiveData<List<ProductResponse>>()
    val products: LiveData<List<ProductResponse>> = _products

    //private val _isLoading = MutableLiveData<Boolean>()
    //val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getProducts() {
        CoroutineScope(Dispatchers.IO).launch {
            //_isLoading.value = true
            try {
                _products.value = repository.getProducts()
            } catch (e: Exception) {
                _error.value = e.message
            }
            //_isLoading.value = false
        }
    }



}