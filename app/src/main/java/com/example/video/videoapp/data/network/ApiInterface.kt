package com.example.video.videoapp.data.network

import com.example.video.videoapp.data.network.model.LayoutResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("video_api.json")
    fun getLayout(): Call<LayoutResponse>
}