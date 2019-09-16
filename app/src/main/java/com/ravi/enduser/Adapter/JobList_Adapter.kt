package com.ravi.enduser.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ravi.enduser.R
import com.ravi.enduser.databinding.JobListItemActivityBinding
import com.ravi.enduser.model.JobList_Model
import com.ravi.enduser.viewmodel.Job_List_Item_ViewModel

class JobList_Adapter(private val job_list:ArrayList<Job_List_Item_ViewModel>,private var context: Context):RecyclerView.Adapter<JobList_Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val jobListActivityBinding: JobListItemActivityBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.job_list_item_activity, parent, false)
return ViewHolder(jobListActivityBinding)
    }

    override fun getItemCount(): Int {

        return job_list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jobListItemViewmodel=job_list[position]
        holder.bind(jobListItemViewmodel)
    }



    class ViewHolder(val jobListActivityBinding: JobListItemActivityBinding) : RecyclerView.ViewHolder( jobListActivityBinding.root) {

        fun bind(jobListItemViewmodel: Job_List_Item_ViewModel) {
            this.jobListActivityBinding.modeljoblist = jobListItemViewmodel
            jobListActivityBinding.executePendingBindings()
//           Log.d("model_value",Job_List_Item_ViewModel.profile)
        }


    }

}