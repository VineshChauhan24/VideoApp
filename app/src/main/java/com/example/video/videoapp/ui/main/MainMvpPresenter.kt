package com.example.video.videoapp.ui.main

import com.example.video.videoapp.ui.base.BasePresenter
import com.example.video.videoapp.ui.base.MvpPresenter

interface MainMvpPresenter<V : MainMvpView> : MvpPresenter<V> {

    fun getLayout()
}