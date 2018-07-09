package com.example.video.videoapp.ui

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.video.videoapp.R
import com.example.video.videoapp.data.network.model.Content
import com.example.video.videoapp.ui.main.ImageClickListener
import com.mindorks.placeholderview.annotations.*

@NonReusable
@Layout(R.layout.item_portrait)
class RailPortrait internal constructor(private val context : Context, private val imageUrl: String,
                                        private var title: String,
                                        private val mListener: ImageClickListener,
                                        private val railPosition: Int){

    @View(R.id.portrait_imageView)
    lateinit var portrait_imageView: ImageView

    @View(R.id.tv_title)
    lateinit var tv_title: TextView

    @JvmField
    @Position
    var position: Int = 0

    @Resolve
    fun onAttach(){
        Glide.with(context).load(imageUrl).into(portrait_imageView)
        tv_title.text = title
    }

    @Click(R.id.portrait_imageView)
    fun onClick(){
        mListener.onImageClicked(railPosition, position)
    }

}