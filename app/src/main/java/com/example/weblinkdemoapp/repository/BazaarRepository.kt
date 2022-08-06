package com.example.weblinkdemoapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weblinkdemoapp.Utils.NetworkUtils
import com.example.weblinkdemoapp.api.ApiService
import com.example.weblinkdemoapp.model.InfoResult

class BazaarRepository (
    private val apiService: ApiService,
    private val applicationContext: Context
) {

    private val dataset = MutableLiveData<List<InfoResult>>()

    val users: LiveData<List<InfoResult>>
        get() = dataset

    suspend fun getUsersData() {
        if (NetworkUtils.isInternetAvailable(applicationContext)) {

            val response = apiService.getData()
            if (response.body() != null)

            dataset.postValue(response.body())
        }
    }
}