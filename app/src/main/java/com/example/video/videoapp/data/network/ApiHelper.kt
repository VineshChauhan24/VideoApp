package com.example.video.videoapp.data.network

import com.example.video.videoapp.data.network.model.LayoutResponse

interface ApiHelper{
    interface OnFinishedListener {
        fun onSuccess(layoutResponse : LayoutResponse)
        fun onFailure(throwable: Throwable)
    }

    fun getLayoutDetails(onFinishedListener: OnFinishedListener)
}