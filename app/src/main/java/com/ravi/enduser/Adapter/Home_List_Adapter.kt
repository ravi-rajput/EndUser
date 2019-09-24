package com.ravi.enduser.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ravi.enduser.R
import com.ravi.enduser.databinding.HomeListItemBinding
import com.ravi.enduser.viewmodel.Home_Item_ViewModel

class Home_List_Adapter(val arrayList: ArrayList<Home_Item_ViewModel>, val context:Context) : RecyclerView.Adapter<Home_List_Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
val homeListItemBinding:HomeListItemBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
        R.layout.home_list_item, parent, false)
        return ViewHolder(homeListItemBinding)
    }

    override fun getItemCount(): Int {
return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
val homeItemViewmodel=arrayList[position]
        holder.bind(homeItemViewmodel)
    }

    class ViewHolder(val homeListItemBinding: HomeListItemBinding):RecyclerView.ViewHolder(homeListItemBinding.root){

fun bind( homeItemViewmodel: Home_Item_ViewModel)
{
    this.homeListItemBinding.modelhomeitem=homeItemViewmodel
    homeListItemBinding.executePendingBindings()
}

    }
}