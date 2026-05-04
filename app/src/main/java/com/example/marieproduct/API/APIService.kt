package com.example.marieproduct.API

import com.example.marieproduct.data.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("pokemon/{id}")
    suspend fun getPokemon(@Path("id") id: Int): Pokemon
}