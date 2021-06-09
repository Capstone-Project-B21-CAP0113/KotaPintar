package com.capstone.myapplication.ui.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddViewModel : ViewModel () {
    private val _text = MutableLiveData<String>().apply {
        value = "Fragment Add"
    }
    val text: LiveData<String> = _text
}