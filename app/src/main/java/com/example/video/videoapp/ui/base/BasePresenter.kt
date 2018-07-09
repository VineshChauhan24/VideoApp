package com.example.video.videoapp.ui.base

import com.example.video.videoapp.data.DataManager
import javax.inject.Inject

open class BasePresenter<V : MvpView> @Inject
constructor(val dataManager: DataManager) : MvpPresenter<V> {

    var mMvpView: V? = null
        private set

    val isViewAttached: Boolean
        get() = mMvpView != null

    fun getMvpView(): V {
        return mMvpView!!
    }

    override fun onAttach(mvpView: V) {
        this.mMvpView = mvpView
    }

    override fun onDetach() {
        mMvpView = null
    }


}
