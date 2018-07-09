package com.example.video.videoapp.di.component

import com.example.video.videoapp.ui.main.MainActivity
import com.example.video.videoapp.di.PerActivity
import com.example.video.videoapp.di.module.ActivityModule
import dagger.Component

@PerActivity
@Component(dependencies = [(ApplicationComponent::class)], modules = [(ActivityModule::class)])
interface ActivityComponent {

    fun inject(activity : MainActivity)
}