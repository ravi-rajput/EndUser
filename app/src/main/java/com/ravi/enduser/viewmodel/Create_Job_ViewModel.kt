package com.ravi.enduser.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.*
import androidx.lifecycle.MutableLiveData


class Create_Job_ViewModel : ViewModel(){

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

    fun upload(view:View){

    }
    fun field() : MutableLiveData<Boolean> {

        isClicked.value=false

        return isClicked
    }

    }
