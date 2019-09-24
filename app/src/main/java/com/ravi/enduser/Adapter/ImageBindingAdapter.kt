package com.ravi.enduser.Adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions




    @BindingAdapter("imageUrl1")
     fun loadImage(imageView: ImageView, url:String) {
        val myOptions = RequestOptions()
                .fitCenter() // or centerCrop
                .override(100, 100)

        if (!url.equals("")) {
            Glide.with(imageView.getContext()).apply{myOptions}.load(url).into(imageView);
        }
}