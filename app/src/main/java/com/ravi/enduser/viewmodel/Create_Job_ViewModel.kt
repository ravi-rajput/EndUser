package com.ravi.enduser.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.*
import androidx.lifecycle.MutableLiveData


class Create_Job_ViewModel : ViewModel(){

    var name= MutableLiveData<String>()
    // Create a LiveData with a String
    var isClicked= MutableLiveData<Boolean> ()

    fun clicked(view:View){
        Log.d("button_status","clicked")
        isClicked.postValue(true)

    }
    fun clicked1(view:View){
        Log.d("button_status","clicked")
        isClicked.postValue(false)

    }
    fun field() : MutableLiveData<Boolean> {

        isClicked.value=false

        return isClicked
    }

    fun getArrayList(name1:String) : MutableLiveData<String> {
        name.value=name1

        return name
    }
    }
