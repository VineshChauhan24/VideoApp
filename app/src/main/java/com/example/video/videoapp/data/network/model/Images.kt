package com.example.video.videoapp.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Images(@SerializedName("PORTRAIT") @Expose val typePortrait : String,
                  @SerializedName("BANNER") @Expose  val typeBanner : String)