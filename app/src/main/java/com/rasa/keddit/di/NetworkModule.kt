package com.rasa.keddit.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Created by cosmi on 26-Nov-17.
 */
@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }
}