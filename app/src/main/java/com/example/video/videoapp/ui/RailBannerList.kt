package com.example.video.videoapp.ui

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.example.video.videoapp.R
import com.example.video.videoapp.data.network.model.Content
import com.example.video.videoapp.ui.main.ImageClickListener
import com.mindorks.placeholderview.PlaceHolderView
import com.mindorks.placeholderview.annotations.*

@NonReusable
@Layout(R.layout.item_banner_list)
class RailBannerList (private val context : Context, private val imageList: List<Content>,
                      private val listener: ImageClickListener){

    @View(R.id.placeholderview)
    lateinit var mPlaceHolderView: PlaceHolderView

    @JvmField
    @Position
    var position: Int = 0

    @Resolve
    fun onAttach(){
        mPlaceHolderView.builder.setHasFixedSize(true)
                .setItemViewCacheSize(10)
                .setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false))

        for (i in 0 until  imageList.size){
            mPlaceHolderView.addView(RailBanner(context, imageList[i].images.typeBanner, listener, position))
        }
    }

    @Click(R.id.tv_more)
    fun onClick() {
        Log.e("RailBannerList", "more clicked $position")
    }
}