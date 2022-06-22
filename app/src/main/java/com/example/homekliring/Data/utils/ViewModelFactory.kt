package com.example.homekliring.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.homekliring.DataStore.DataStoreRepository

// since I put constructor in MenuMainViewModel I need to use ViewModelFactory to be able
// initialized the view-model
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val dataStoreRepository: DataStoreRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}