package com.ravi.enduser.ModelFactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ravi.enduser.model.MainDashboard_Model
import com.ravi.enduser.viewmodel.Main_Dashboard_ViewModel

class Main_DashboardViewmodelFactory(var context: Context,var mainDashboard_Model: MainDashboard_Model): ViewModelProvider.NewInstanceFactory() {

    override fun <D : ViewModel> create(modelClass: Class<D>): D {
        return Main_Dashboard_ViewModel(context,mainDashboard_Model) as D
    }
}