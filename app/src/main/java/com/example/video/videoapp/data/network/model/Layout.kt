package com.example.video.videoapp.data.network.model

import com.example.video.videoapp.data.db.model.Rails
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Layout(@SerializedName("rails")
                  @Expose
                  val rails: List<Rail>? = null)