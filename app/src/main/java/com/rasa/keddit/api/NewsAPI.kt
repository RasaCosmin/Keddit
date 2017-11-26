package com.rasa.keddit.api

import retrofit2.Call

/**
 * Created by cosmi on 26-Nov-17.
 */
interface NewsAPI {
    fun getNews(after: String, limit: String): Call<RedditNewsResponse>
}