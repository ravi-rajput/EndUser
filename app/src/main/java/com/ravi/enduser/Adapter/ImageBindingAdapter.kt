package com.ravi.enduser.Adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


    @BindingAdapter("imageUrl1")
     fun loadImage(imageView: ImageView, url:String) {
        if (!url.equals("")) {
            Glide.with(imageView.getContext()).load(url).into(imageView);
        }
}