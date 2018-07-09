package com.example.video.videoapp.ui.base

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.example.video.videoapp.AppController
import com.example.video.videoapp.R
import com.example.video.videoapp.di.component.ActivityComponent
import com.example.video.videoapp.di.component.DaggerActivityComponent
import com.example.video.videoapp.di.module.ActivityModule
import com.example.video.videoapp.utils.CommonUtils

abstract class BaseActivity : AppCompatActivity(), MvpView {

    private var mProgressDialog: ProgressBar? = null

    private var mActivityComponent : ActivityComponent? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent((application as AppController).getApplicationComponent())
                .build()
    }

    fun getActivityComponent() : ActivityComponent {
        return mActivityComponent!!
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = createProgressBar()
        mProgressDialog!!.visibility = View.VISIBLE
    }

    abstract fun createProgressBar(): ProgressBar

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.visibility == View.VISIBLE)
            mProgressDialog!!.visibility = View.GONE

    }

    private fun showSnackBar(message: String){
        val snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT)
        val sbView = snackbar.view
        val textView = sbView
                .findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
        textView.setTextColor(ContextCompat.getColor(this, R.color.white))
        snackbar.show()
    }

    override fun onError(message: String?) {
        if (message != null) {
            showSnackBar(message)
        } else {
            showSnackBar(getString(R.string.some_error))
        }
    }

    override fun onError(resId: Int) {
        onError(getString(resId))
    }

    override fun showMessage(message: String?) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_SHORT).show()
        }
    }

    override fun showMessage(resId: Int) {
        showMessage(getString(resId))
    }

    override fun isNetworkConnected(): Boolean {
        return false
    }


}