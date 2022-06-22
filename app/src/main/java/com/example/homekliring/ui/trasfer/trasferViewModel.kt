package com.example.homekliring.ui.trasfer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class trasferViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is trasfer Fragment"
    }
    val text: LiveData<String> = _text
}