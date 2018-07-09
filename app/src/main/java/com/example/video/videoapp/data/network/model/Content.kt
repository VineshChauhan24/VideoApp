package com.example.video.videoapp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Content(@SerializedName("_id") @Expose val id: String,
                   @SerializedName("playId") @Expose val playId: String,
                   @SerializedName("images") @Expose val images : Images,
                   @SerializedName("title") @Expose val title: String) {
}