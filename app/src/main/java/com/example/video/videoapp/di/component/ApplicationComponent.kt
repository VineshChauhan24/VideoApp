package com.example.video.videoapp.di.component

import android.app.Application
import android.content.Context
import com.example.video.videoapp.AppController
import com.example.video.videoapp.data.DataManager
import com.example.video.videoapp.di.ApplicationContext
import com.example.video.videoapp.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {

    fun inject(app: AppController)

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun getDataManager(): DataManager
}