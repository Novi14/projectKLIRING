package com.example.homekliring.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class helpViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is help Fragment"
    }
    val text: LiveData<String> = _text
}