package com.example.weblinkdemoapp.api

import com.example.weblinkdemoapp.model.InfoResult
import retrofit2.Response

import retrofit2.http.GET

interface ApiService {

    @GET("demo")
    suspend fun getData(): Response<List<InfoResult>>

}