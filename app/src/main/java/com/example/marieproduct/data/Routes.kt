package com.example.marieproduct.data

sealed interface Routes {
    data object Home: Routes
    data class Form (val productName: String): Routes

    data object API: Routes
}