package com.example.video.videoapp.ui.base

interface MvpPresenter<V : MvpView> {

    fun onAttach(mvpView: V)

    fun onDetach()
}