package com.example.video.videoapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import com.example.video.videoapp.R
import com.example.video.videoapp.data.network.model.Content
import com.example.video.videoapp.ui.*
import com.example.video.videoapp.ui.base.BaseActivity
import com.example.video.videoapp.ui.videoplayer.TestActivity
import com.example.video.videoapp.ui.videoplayer.VideoPlayerActivity
import com.example.video.videoapp.utils.AppConstants
import com.example.video.videoapp.utils.CommonUtils
import com.mindorks.placeholderview.PlaceHolderView
import javax.inject.Inject

class MainActivity : BaseActivity(),MainMvpView {

    @Inject
    internal lateinit var mPresenter: MainMvpPresenter<MainMvpView>

    private var mGalleryView: PlaceHolderView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getActivityComponent().inject(this)

        mPresenter.onAttach(this)
        mPresenter.getLayout()
        mGalleryView = findViewById(R.id.galleryView)

    }

    override fun navigateToVideoPlayerActivity(title: String, playId: String) {
        //val intent = VideoPlayerActivity.newIntent(this, title, playId)
        val intent = TestActivity.newIntent(this, title, playId)
        startActivity(intent)
    }

    override fun createProgressBar() : ProgressBar {
        return CommonUtils.createProgressBar(this,
                findViewById<View>(R.id.progress_root_layout) as RelativeLayout)
    }



    override fun addPortraitView(contentList: List<Content>, listener: ImageClickListener) {
            mGalleryView!!.addView(RailPortraitList(this, contentList, listener))
    }

    override fun addBannerView(contentList: List<Content>, listener: ImageClickListener) {
        mGalleryView!!.addView(RailBannerList(this, contentList, listener))
    }
}

