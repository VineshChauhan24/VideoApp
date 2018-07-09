package com.example.video.videoapp.di.module

import android.app.Application
import android.content.Context
import com.example.video.videoapp.data.AppDataManager
import com.example.video.videoapp.data.DataManager
import com.example.video.videoapp.data.db.AppDbHelper
import com.example.video.videoapp.data.db.DbHelper
import com.example.video.videoapp.data.network.ApiHelper
import com.example.video.videoapp.data.network.AppApiHelper

import com.example.video.videoapp.di.ApplicationContext
import com.example.video.videoapp.di.DatabaseInfo
import com.example.video.videoapp.utils.AppConstants

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val mApplication: Application) {

    @Provides
    @ApplicationContext
    fun provideContext() : Context = mApplication

    @Provides
    fun provideApplication(): Application = mApplication

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String = AppConstants.DB_NAME

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }
}
