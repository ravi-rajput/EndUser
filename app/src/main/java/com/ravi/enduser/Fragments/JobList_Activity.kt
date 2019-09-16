package com.ravi.enduser.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ravi.enduser.Adapter.JobList_Adapter
import com.ravi.enduser.R
import com.ravi.enduser.viewmodel.Job_List_Item_ViewModel

class JobList_Activity : Fragment(){
    private var recyclerView:RecyclerView?=null
    var joblistAdapter:JobList_Adapter?=null
    var floatingActionButton:FloatingActionButton?=null
//    var imageView:ImageView?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var v:View= inflater!!.inflate(R.layout.job_list_activity, container, false)

        var jobListItemViewmodel= ViewModelProviders.of(this).get(Job_List_Item_ViewModel::class.java)
//         binding.modeljoblist=jobListItemViewmodel
          recyclerView=v.findViewById(R.id.recycler_view)
        floatingActionButton=v.findViewById(R.id.add_jobsfloating)

        jobListItemViewmodel.getArrayList().observe(this,Observer{jobListItemViewmodel->

            joblistAdapter= activity?.let { JobList_Adapter(jobListItemViewmodel!!, it) }
            recyclerView!!.setLayoutManager(LinearLayoutManager(activity))
            recyclerView!!.setAdapter(joblistAdapter)
        })

        floatingActionButton!!.setOnClickListener{
            val toast= Toast.makeText(activity,"button clicked" ,Toast.LENGTH_SHORT).show()
        }

        return v
    }
}