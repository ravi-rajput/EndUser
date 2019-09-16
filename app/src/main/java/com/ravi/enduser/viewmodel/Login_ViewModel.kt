package com.ravi.enduser.viewmodel

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.ravi.enduser.Activity.Home_Activity
import com.ravi.enduser.Activity.SignUP_Activity

class Login_ViewModel(var context: Context):ViewModel() {


    fun onLoginClick(view: View){
        var intent = Intent(context,Home_Activity::class.java)
        context.startActivity(intent)
    }

    fun onSignupClick(view: View){
       var intent = Intent(context,SignUP_Activity::class.java)
        context.startActivity(intent)
    }

}