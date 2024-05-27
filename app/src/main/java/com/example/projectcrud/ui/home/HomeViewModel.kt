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