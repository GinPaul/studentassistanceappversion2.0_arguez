package com.kodego.app.studentassistaneappv20.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Students' Schedule"
    }
    val text: LiveData<String> = _text
}