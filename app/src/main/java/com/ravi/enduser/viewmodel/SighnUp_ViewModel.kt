package com.ravi.enduser.viewmodel

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.ravi.enduser.Activity.Home_Activity
import com.ravi.enduser.Activity.Login_Activity

class SighnUp_ViewModel(var context: Context) :ViewModel(){

    fun onSignupclick(view: View){
        var intent = Intent(context, Home_Activity::class.java)
        context.startActivity(intent)
    }

    fun onLoginClick(view: View){
        var intent=Intent(context, Login_Activity::class.java)
        context.startActivity(intent)
    }

}