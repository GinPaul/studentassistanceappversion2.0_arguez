package com.kodego.app.studentassistaneappv20.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Activities and Assignments"
    }
    val text: LiveData<String> = _text
}