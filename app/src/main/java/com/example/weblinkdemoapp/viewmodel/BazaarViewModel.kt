package com.example.weblinkdemoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weblinkdemoapp.repository.BazaarRepository
import com.example.weblinkdemoapp.model.InfoResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BazaarViewModel(private val repository: BazaarRepository) : ViewModel() {

    //Dispatcher.IO is used to block the threads for IO operation (kotlin coroutines)
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getUsersData()
        }

    }

    val user: LiveData<List<InfoResult>>
        get() = repository.users
}