package com.example.video.videoapp.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout

object CommonUtils {

    fun createProgressBar(context: Context, layout: RelativeLayout) : ProgressBar{
        val progressBar = ProgressBar(context, null, android.R.attr.progressBarStyleLarge)
        val params = RelativeLayout.LayoutParams(300, 300)
        params.addRule(RelativeLayout.CENTER_IN_PARENT)
        layout.addView(progressBar, params)
        progressBar.isIndeterminate = true
        return progressBar
    }
}