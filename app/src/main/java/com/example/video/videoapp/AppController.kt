package com.example.video.videoapp

import android.app.Application
import com.example.video.videoapp.di.component.ApplicationComponent
import com.example.video.videoapp.di.component.DaggerApplicationComponent
import com.example.video.videoapp.di.module.ApplicationModule

class AppController : Application(){

    lateinit var mApplicationComponent : ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()

        mApplicationComponent.inject(this)
    }

    fun getApplicationComponent() : ApplicationComponent{
        return mApplicationComponent
    }

}
