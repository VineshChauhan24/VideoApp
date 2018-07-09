package com.example.video.videoapp.ui

import android.content.Context
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.video.videoapp.R
import com.example.video.videoapp.data.network.model.Content
import com.example.video.videoapp.ui.main.ImageClickListener
import com.mindorks.placeholderview.annotations.*

@NonReusable
@Layout(R.layout.item_banner)
class RailBanner internal constructor(private val context : Context, private val imageUrl: String,
                                      private val listener: ImageClickListener, private val railPosition: Int) {

    @View(R.id.banner_imageView)
    lateinit var banner_imageView: ImageView

    @JvmField
    @Position
    internal var position: Int = 0

    @Resolve
    fun onAttach(){
        Glide.with(context).load(imageUrl).into(banner_imageView)
    }

    @Click(R.id.banner_imageView)
    fun onClick(){
        listener.onImageClicked(railPosition, position)
    }


}