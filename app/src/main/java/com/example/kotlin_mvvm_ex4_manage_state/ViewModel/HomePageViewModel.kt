package com.example.kotlin_mvvm_ex4_manage_state.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomePageViewModel: ViewModel() {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    fun onNameUpdate(newName: String){
        _name.value = newName
    }
}