package com.ravi.enduser.Activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ravi.enduser.Adapter.JobList_Adapter
import com.ravi.enduser.R
import com.ravi.enduser.databinding.CreateJobActivityBinding
import com.ravi.enduser.model.CreateJob_Model
import com.ravi.enduser.viewmodel.Create_Job_ViewModel

class Create_Job_Activity : AppCompatActivity() {
    private lateinit var binding: CreateJobActivityBinding
    private lateinit var createJobViewmodel: Create_Job_ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= DataBindingUtil.setContentView(this, R.layout.create_job_activity)
        createJobViewmodel=ViewModelProviders.of(this).get(Create_Job_ViewModel::class.java)

        binding.setLifecycleOwner(this);
       binding.modelceatejob=createJobViewmodel

        // Create the observer which updates the UI.
        val nameObserver = Observer<Boolean> { newName ->

        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        createJobViewmodel.field().observe(this, nameObserver)

        createJobViewmodel.getArrayList("Rajput").observe(this,Observer{jobListItemViewmodel->
        })

    }

}

