package com.example.tp3_parcial_belgrano_grupo4.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Home Fragment"
    }
    val text: LiveData<String> = _text
}