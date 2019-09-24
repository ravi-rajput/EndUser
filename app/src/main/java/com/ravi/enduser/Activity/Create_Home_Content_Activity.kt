package com.ravi.enduser.Activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ravi.enduser.R
import com.ravi.enduser.databinding.CreateHomeContentBinding
import com.ravi.enduser.viewmodel.Create_Home_Content_ViewModel

class Create_Home_Content_Activity:AppCompatActivity() {

    lateinit var binding: CreateHomeContentBinding
    lateinit var createHomeContentViewmodel: Create_Home_Content_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this, R.layout.create_home_content)
        createHomeContentViewmodel=ViewModelProviders.of(this).get(Create_Home_Content_ViewModel::class.java)

        binding.lifecycleOwner=this
        binding.modelcreatehome=createHomeContentViewmodel


    }

}