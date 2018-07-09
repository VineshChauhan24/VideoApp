package com.example.video.videoapp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LayoutResponse(@SerializedName("layout")
                        @Expose
                        val layout: Layout,
                          @SerializedName("packages")
                        @Expose
                        val packageMap : HashMap<String, PackageDetails>)