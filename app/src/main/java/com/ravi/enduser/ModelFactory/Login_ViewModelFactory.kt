package com.ravi.enduser.ModelFactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ravi.enduser.model.MainDashboard_Model
import com.ravi.enduser.viewmodel.Login_ViewModel
import com.ravi.enduser.viewmodel.Main_Dashboard_ViewModel

class Login_ViewModelFactory(var context: Context): ViewModelProvider.NewInstanceFactory() {

    override fun <D : ViewModel> create(modelClass: Class<D>): D {
        return Login_ViewModel(context) as D
    }}