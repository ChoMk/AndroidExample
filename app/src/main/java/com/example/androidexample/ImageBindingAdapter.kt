package com.example.androidexample

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * @author MyeongKi
 */
object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(
        imageView: ImageView, imageUrl: String) {
        val glideRequest = Glide.with(imageView.context).load(imageUrl)
        glideRequest.into(imageView)
    }
}