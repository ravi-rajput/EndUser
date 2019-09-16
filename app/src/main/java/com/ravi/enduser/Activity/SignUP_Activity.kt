package com.ravi.enduser.Activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ravi.enduser.ModelFactory.Signup_ViewModelFactory
import com.ravi.enduser.R
import com.ravi.enduser.databinding.SighnupActivityBinding
import com.ravi.enduser.viewmodel.SighnUp_ViewModel

class SignUP_Activity:AppCompatActivity() {
    private lateinit var binding: SighnupActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this, R.layout.sighnup_activity)
        var SighnUp_ViewModel=ViewModelProviders.of(this, Signup_ViewModelFactory(this)).get(SighnUp_ViewModel::class.java)
        binding.modelsighnup=SighnUp_ViewModel

    }

}