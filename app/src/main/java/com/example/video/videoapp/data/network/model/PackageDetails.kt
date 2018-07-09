package com.example.video.videoapp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PackageDetails(@SerializedName("contents")
                          @Expose
                          val contents: List<Content>? = null) {
}