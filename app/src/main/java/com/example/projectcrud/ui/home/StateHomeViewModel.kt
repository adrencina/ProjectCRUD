package com.example.projectcrud.ui.home


sealed class StateHomeViewModel {
    data class Success(val products: List<ProductResponse>) : StateHomeViewModel()
    data class Error(val message: String) : StateHomeViewModel()
}