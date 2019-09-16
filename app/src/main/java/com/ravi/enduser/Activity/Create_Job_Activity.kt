package com.ravi.enduser.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.ravi.enduser.R
import com.ravi.enduser.databinding.CreateJobActivityBinding
import com.ravi.enduser.viewmodel.Create_Job_ViewModel

class Create_Job_Activity : AppCompatActivity() {
    private lateinit var binding: CreateJobActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= DataBindingUtil.setContentView(this, R.layout.create_job_activity)
        var createJobViewmodel=ViewModelProviders.of(this).get(Create_Job_ViewModel::class.java)

       binding.modelceatejob=createJobViewmodel
    }

}