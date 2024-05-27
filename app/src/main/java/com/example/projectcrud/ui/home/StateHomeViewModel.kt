package com.example.projectcrud.ui.home

open class StateHomeViewModel {
    data class Success( val info: ProductResponse) : StateHomeViewModel()
    data class Error( val message: String) : StateHomeViewModel()
    }