package com.rasa.keddit.di.news

import com.rasa.keddit.api.NewsAPI
import com.rasa.keddit.api.NewsRestAPI
import com.rasa.keddit.api.RedditApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by cosmi on 26-Nov-17.
 */
@Module
class NewsModule {
    @Provides
    @Singleton
    fun providesNewsAPI(redditApi: RedditApi): NewsAPI {
        return NewsRestAPI(redditApi)
    }

    @Provides
    @Singleton
    fun providesRedditApi(retrofit: Retrofit): RedditApi {
        return retrofit.create(RedditApi::class.java)
    }

    /**
     * NewsManager is automatically provided by Dagger as we set the @Inject annotation in the
     * constructor, so we can avoid adding a 'provider method' here.
     */
}