package com.example.weblinkdemoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weblinkdemoapp.repository.BazaarRepository

    class BazaarViewModelFactory(private val repository: BazaarRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BazaarViewModel(repository) as T
    }
}