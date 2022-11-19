package com.kodego.app.studentassistaneappv20.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Teachers' Schedule"
    }
    val text: LiveData<String> = _text
}