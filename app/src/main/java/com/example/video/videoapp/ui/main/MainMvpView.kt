package com.example.video.videoapp.ui.main

import com.example.video.videoapp.data.network.model.Content
import com.example.video.videoapp.ui.RailBanner
import com.example.video.videoapp.ui.base.MvpView

interface MainMvpView : MvpView {

    fun addPortraitView(contentList : List<Content>, listener: ImageClickListener)

    fun addBannerView(contentList: List<Content>, listener: ImageClickListener)

    fun navigateToVideoPlayerActivity(title: String, playId: String)
}