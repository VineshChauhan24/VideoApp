package com.example.video.videoapp.ui.main

import android.util.Log
import com.example.video.videoapp.data.DataManager
import com.example.video.videoapp.data.network.ApiHelper
import com.example.video.videoapp.data.network.model.LayoutResponse
import com.example.video.videoapp.data.network.model.PackageDetails
import com.example.video.videoapp.data.network.model.Rail
import com.example.video.videoapp.ui.base.BasePresenter
import javax.inject.Inject

class MainPresenter<V : MainMvpView>@Inject
constructor(dataManager : DataManager) : BasePresenter<V>(dataManager), MainMvpPresenter<V>,
        ApiHelper.OnFinishedListener, ImageClickListener{

    private lateinit var railsList : List<Rail>
    private lateinit var packageMap: HashMap<String, PackageDetails>

    override fun getLayout() {
        getMvpView().showLoading()
        dataManager.getLayoutDetails(this)
    }

    override fun onFailure(throwable: Throwable) {
        getMvpView().hideLoading()
        getMvpView().showMessage("Some Error Occurred!!")
    }

    override fun onSuccess(layoutResponse: LayoutResponse) {
        getMvpView().hideLoading()
        val layoutInfo = layoutResponse.layout
        packageMap = layoutResponse.packageMap
        railsList = layoutInfo.rails!!
            for (list in railsList){
                val packageDetails = packageMap[list.packageName]
                if(list.type == TYPEBANNER){
                    getMvpView().addBannerView(packageDetails!!.contents!!, this)
                }else if (list.type == TYPEPORTRAIT){
                    getMvpView().addPortraitView(packageDetails!!.contents!!, this)
                }
            }

    }

    override fun onImageClicked(railPosition: Int, imagePosition: Int) {
        Log.e("MainPresenter", "railPosition $railPosition ImageClicked $imagePosition")
        val contentList = packageMap[railsList[railPosition].packageName]!!.contents
        val playID = contentList?.get(imagePosition)?.playId
        val title = contentList?.get(imagePosition)?.title

        getMvpView().navigateToVideoPlayerActivity(title!!, playID!!)
    }

    companion object {
        private val TYPEBANNER = "BANNER"
        private val TYPEPORTRAIT = "PORTRAIT"
    }


}