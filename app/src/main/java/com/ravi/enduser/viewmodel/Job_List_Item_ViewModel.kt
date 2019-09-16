package com.ravi.enduser.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ravi.enduser.model.JobList_Model

class Job_List_Item_ViewModel :ViewModel{


    var profile=""
    var company_name=""
    var contact_no =""
    var datetime=""

    constructor():super()
    constructor(joblistModel: JobList_Model) : super() {
        this.profile = joblistModel.profile
        this.company_name = joblistModel.company_name
        this.contact_no = joblistModel.contact_no
        this.datetime = joblistModel.datetime
    }

var arrayListmutablelivedata = MutableLiveData<ArrayList<Job_List_Item_ViewModel>>()

    var arraylist=ArrayList<Job_List_Item_ViewModel>()


    fun getArrayList() : MutableLiveData<ArrayList<Job_List_Item_ViewModel>>{

//     for(i in 1..5) {

         val joblistModel = JobList_Model("Android App Developer", "Gautam Solar Pvt Ltd", "8218539019", "Post at : 4/09/2019")

         val jobListItemViewmodel: Job_List_Item_ViewModel = Job_List_Item_ViewModel(joblistModel)

        val joblistModel1 = JobList_Model("Service Technician", "Galo Energy", "8218539017", "Post at : 4/09/2019")

        val jobListItemViewmodel1: Job_List_Item_ViewModel = Job_List_Item_ViewModel(joblistModel1)

        val joblistModel2 = JobList_Model("Sales Executive", "Gautam Solar Pvt Ltd", "8218539017", "Post at : 4/09/2019")

        val jobListItemViewmodel2: Job_List_Item_ViewModel = Job_List_Item_ViewModel(joblistModel2)

        val joblistModel3 = JobList_Model("Collection Agent", "Gautam Solar Pvt Ltd", "8218539017", "Post at : 4/09/2019")

        val jobListItemViewmodel3: Job_List_Item_ViewModel = Job_List_Item_ViewModel(joblistModel3)


        arraylist!!.add(jobListItemViewmodel)
        arraylist!!.add(jobListItemViewmodel1)
        arraylist!!.add(jobListItemViewmodel2)
        arraylist!!.add(jobListItemViewmodel3)

//     }
        arrayListmutablelivedata.value=arraylist

        return arrayListmutablelivedata
    }

}