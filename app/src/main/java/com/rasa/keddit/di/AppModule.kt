package com.rasa.keddit.di

import android.content.Context
import com.rasa.keddit.KedditApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by cosmi on 26-Nov-17.
 */

@Module
class AppModule(val app: KedditApp) {
    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication(): KedditApp = app
}