package com.example.video.videoapp.data

import android.content.Context
import com.example.video.videoapp.data.db.DbHelper
import com.example.video.videoapp.data.network.ApiHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject
constructor(dbHelper: DbHelper, apiHelper: ApiHelper)
    : DataManager {

    private val mApiHelper = apiHelper
    private val mDbHelper = dbHelper

    override fun getLayoutDetails(onFinishedListener: ApiHelper.OnFinishedListener) {
        mApiHelper.getLayoutDetails(onFinishedListener)
    }

}
