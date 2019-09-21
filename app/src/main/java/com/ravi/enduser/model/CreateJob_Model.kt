package com.ravi.enduser.model

import androidx.lifecycle.MutableLiveData

class CreateJob_Model{


    var name: MutableLiveData<String>

    var isClicked:Boolean=false
        get() = field

        set(value) {
            field = value

        }

    constructor(name: MutableLiveData<String>) {
        this.name = name
    }
}