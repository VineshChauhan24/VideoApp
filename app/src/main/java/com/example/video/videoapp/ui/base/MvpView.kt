package com.example.video.videoapp.ui.base

import android.support.annotation.StringRes
import android.widget.RelativeLayout

interface MvpView {

    fun showLoading()

    fun hideLoading()

    fun onError(@StringRes resId: Int)

    fun onError(message: String?)

    fun showMessage(message: String?)

    fun showMessage(@StringRes resId: Int)

    fun isNetworkConnected(): Boolean
}