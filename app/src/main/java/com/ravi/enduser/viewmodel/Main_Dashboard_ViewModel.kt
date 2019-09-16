package com.ravi.enduser.viewmodel

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.ravi.enduser.Fragments.JobList_Activity
import com.ravi.enduser.model.MainDashboard_Model


class Main_Dashboard_ViewModel(var context: Context, val mainDashboard_Model: MainDashboard_Model) :  ViewModel(){

     var name= mainDashboard_Model.name

     fun onClick1(view: View){
          val toast = Toast.makeText(context, name, Toast.LENGTH_LONG)
          toast.show()
     }
     fun onClick2(view: View){
          var intent = Intent(context, JobList_Activity::class.java)
          context.startActivity(intent)
     }
     fun onClick3(view: View){
          val toast = Toast.makeText(context, "jhfgyh", Toast.LENGTH_LONG)
          toast.show()
     }
     fun onClick4(view: View){
          val toast = Toast.makeText(context, "jhfgyh", Toast.LENGTH_LONG)
          toast.show()
     }
}