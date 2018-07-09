package com.example.video.videoapp.data.network

import android.util.Log
import com.example.video.videoapp.data.network.model.LayoutResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppApiHelper @Inject constructor(): ApiHelper {
    override fun getLayoutDetails(onFinishedListener: ApiHelper.OnFinishedListener) {

        val apiService = ApiClient.getClient().create(ApiInterface::class.java)

        val call = apiService.getLayout()

        call.enqueue(object : Callback<LayoutResponse> {
            override fun onResponse(call: Call<LayoutResponse>, response: Response<LayoutResponse>) {

                val layoutResult = response.body()

                onFinishedListener.onSuccess(layoutResult!!)

            }

            override fun onFailure(call: Call<LayoutResponse>, t: Throwable) {
                onFinishedListener.onFailure(t)
            }
        })
    }
}