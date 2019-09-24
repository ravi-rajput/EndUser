package com.ravi.enduser.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ravi.enduser.model.Home_Content_List_Model

class Home_Item_ViewModel:ViewModel {

    var name=""
    var datetime=""
    var title=""
    var disc=""
    var image=""

    constructor() : super()

    constructor(model: Home_Content_List_Model) : super() {
        this.name = model.name
        this.datetime = model.datetime
        this.title = model.title
        this.disc = model.disc
        this.image = model.image
    }
var arraylistMutableLivedata = MutableLiveData<ArrayList<Home_Item_ViewModel>>()
        var arrayList=ArrayList<Home_Item_ViewModel>()

fun getArraylist():MutableLiveData<ArrayList<Home_Item_ViewModel>>{

    val homeContentListModel=Home_Content_List_Model("RaviRajput","25 Sept, 02:19PM","Wood Bridge","Flowers are also called the bloom or blossom of a plant. Flowers have petals. Inside the part of the flower that has petals are the parts which produce pollen and seeds. In all plants, a flower is usually its most colorful part.",
            "https://images.all-free-download.com/images/graphicthumb/flower_white_small_235917.jpg")
    val homeItemViewmodel=Home_Item_ViewModel(homeContentListModel)

    val homeContentListModel1=Home_Content_List_Model("Ravi Rajput","25 Sept, 02:19PM","Flowers - Blue Rose","Flowers are also called the bloom or blossom of a plant. Flowers have petals. Inside the part of the flower that has petals are the parts which produce pollen and seeds. In all plants, a flower is usually its most colorful part.",
            "https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500")
    val homeItemViewmodel1=Home_Item_ViewModel(homeContentListModel1)


    arrayList.add(homeItemViewmodel)
    arrayList.add(homeItemViewmodel1)

    arraylistMutableLivedata.value=arrayList

    return arraylistMutableLivedata
}
}