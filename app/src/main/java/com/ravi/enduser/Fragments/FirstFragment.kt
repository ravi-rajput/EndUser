package com.ravi.enduser.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ravi.enduser.R
import androidx.recyclerview.widget.RecyclerView
import com.ravi.enduser.Adapter.Home_List_Adapter
import com.ravi.enduser.viewmodel.Home_Item_ViewModel

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {
var recyclerView:RecyclerView?=null
var homeListAdapter:Home_List_Adapter?=null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view:View= inflater!!.inflate(R.layout.fragment_first, container, false)
        var homeItemViewmodel= ViewModelProviders.of(this).get(Home_Item_ViewModel::class.java)

        recyclerView=view.findViewById(R.id.recycler_view)

        homeItemViewmodel.getArraylist().observe(this, Observer { homeItemViewmodel->

            homeListAdapter=activity?.let {Home_List_Adapter(homeItemViewmodel!!,it)}
            recyclerView!!.setLayoutManager(LinearLayoutManager(activity))
            recyclerView!!.setAdapter(homeListAdapter)
        })

        return view
    }
}