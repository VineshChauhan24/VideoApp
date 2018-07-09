package com.example.video.videoapp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rail(@SerializedName("_id") @Expose val id: String,
                @SerializedName("type") @Expose val type: String,
                @SerializedName("package") @Expose val packageName: String) {
}