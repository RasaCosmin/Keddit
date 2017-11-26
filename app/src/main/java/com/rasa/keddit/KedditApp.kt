package com.rasa.keddit

import android.app.Application
import com.rasa.keddit.di.AppModule
import com.rasa.keddit.di.news.DaggerNewsComponent
import com.rasa.keddit.di.news.NewsComponent

/**
 * Created by cosmi on 26-Nov-17.
 */
class KedditApp : Application(){
    companion object {
        lateinit var newsComponent: NewsComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerNewsComponent.builder()
                .appModule(AppModule(this))
                //.newsModule(NewsModule()) Module with empty constructor is implicitly created by dagger
                .build()
    }
}