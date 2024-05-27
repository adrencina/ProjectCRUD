package com.example.projectcrud.ui.home

//open class StateHomeViewModel {
    //data class Success( val info: List<ProductResponse>) : StateHomeViewModel()
    //data class Error( val message: String) : StateHomeViewModel()
open class StateHomeViewModel {
        data class Success( val data: List<ProductResponse>) : StateHomeViewModel()
        data class Error( val message: String) : StateHomeViewModel()
    }
    //}