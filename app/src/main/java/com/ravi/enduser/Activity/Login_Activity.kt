package com.ravi.enduser.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ravi.enduser.Adapter.JobList_Adapter
import com.ravi.enduser.ModelFactory.Login_ViewModelFactory
import com.ravi.enduser.R
import com.ravi.enduser.databinding.LoginActivityBinding
import com.ravi.enduser.viewmodel.Login_ViewModel

class Login_Activity:AppCompatActivity() {

    private lateinit var binding: LoginActivityBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= DataBindingUtil.setContentView(this, R.layout.login_activity)
        var Login_ViewModel= ViewModelProviders.of(this, Login_ViewModelFactory(this)).get(Login_ViewModel::class.java)
        binding.modellogin=Login_ViewModel

    }

}