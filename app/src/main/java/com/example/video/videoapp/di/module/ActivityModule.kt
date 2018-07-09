package com.example.video.videoapp.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity

import com.example.video.videoapp.di.ActivityContext
import com.example.video.videoapp.di.PerActivity
import com.example.video.videoapp.ui.main.MainMvpPresenter
import com.example.video.videoapp.ui.main.MainMvpView
import com.example.video.videoapp.ui.main.MainPresenter

import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val mActivity: AppCompatActivity) {

    @Provides
    @ActivityContext
    internal fun provideContext(): Context {
        return mActivity
    }

    @Provides
    internal fun provideActivity(): AppCompatActivity {
        return mActivity
    }

    //provide dependency for all the presenters
    @Provides
    @PerActivity
    internal fun provideMainPresenter(presenter: MainPresenter<MainMvpView>)
            : MainMvpPresenter<MainMvpView>{
        return presenter
    }

}
