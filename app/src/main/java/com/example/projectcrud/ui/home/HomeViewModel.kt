package com.example.projectcrud.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import com.example.projectcrud.repository.HomeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class HomeViewModel(private val repository: HomeRepository = HomeRepository()) : ViewModel() {

    private val _products = MutableLiveData<StateHomeViewModel>()
    val products: LiveData<StateHomeViewModel> = _products

    fun getProducts() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getProducts()
            if (response.isSuccessful) {
                response.body()?.let {
                    _products.postValue(StateHomeViewModel.Success(it))
                } ?: _products.postValue(StateHomeViewModel.Error("No data"))
            } else {
                _products.postValue(StateHomeViewModel.Error("Service error"))
            }
        }
    }
}