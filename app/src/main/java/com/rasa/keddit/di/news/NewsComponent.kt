package com.rasa.keddit.di.news

import com.rasa.keddit.di.AppModule
import com.rasa.keddit.di.NetworkModule
import com.rasa.keddit.features.news.NewsFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by cosmi on 26-Nov-17.
 */

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NewsModule::class,
        NetworkModule::class
))
interface NewsComponent {
    fun inject(newsFragment: NewsFragment)
}