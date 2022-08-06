package com.example.weblinkdemoapp

import android.app.Application
import com.example.weblinkdemoapp.api.ApiService
import com.example.weblinkdemoapp.api.RetrofitBuilder
import com.example.weblinkdemoapp.repository.BazaarRepository

class BazaarApplication : Application (){

    lateinit var repository: BazaarRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize(){
        val service = RetrofitBuilder.getInstance().create(ApiService::class.java)
        repository = BazaarRepository(service, applicationContext)
    }
}