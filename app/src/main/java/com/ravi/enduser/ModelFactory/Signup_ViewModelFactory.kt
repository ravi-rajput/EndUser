package com.ravi.enduser.ModelFactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ravi.enduser.viewmodel.Login_ViewModel
import com.ravi.enduser.viewmodel.SighnUp_ViewModel

class Signup_ViewModelFactory(var context: Context):ViewModelProvider.NewInstanceFactory() {
    override fun <D : ViewModel> create(modelClass: Class<D>): D {
        return SighnUp_ViewModel(context) as D
    }}
