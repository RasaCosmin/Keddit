package com.rasa.keddit.features.news

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rasa.keddit.R
import com.rasa.keddit.commons.InfiniteScrollListener
import com.rasa.keddit.commons.RedditNews
import com.rasa.keddit.commons.RedditNewsItem
import com.rasa.keddit.commons.RxBaseFragment
import com.rasa.keddit.commons.extemsions.inflate
import com.rasa.keddit.features.news.adapter.NewsAdapter

import kotlinx.android.synthetic.main.news_fragment.*;
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by cosmi on 18-Nov-17.
 */
class NewsFragment : RxBaseFragment() {

    private val newsList by lazy {
        news_list
    }

    private val newsManager by lazy {
        NewsManager()
    }

    private var redditNews: RedditNews? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        newsList?.setHasFixedSize(true)
        val linearLayout = LinearLayoutManager(context)
        newsList?.layoutManager = linearLayout
        newsList.clearOnScrollListeners()
        newsList?.addOnScrollListener(
                InfiniteScrollListener({requestNews()}, linearLayout)
        )

        initAdapter()

        if (savedInstanceState == null) {
            requestNews()

        }
    }

    private fun requestNews() {
        val subscription = newsManager.getNews(redditNews?.after?:"")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { retrievedNews ->
                            redditNews = retrievedNews
                            (newsList.adapter as NewsAdapter).addNews(retrievedNews.news)
                        },
                        { e ->
                            Snackbar.make(newsList,e.message?:"eroare", Snackbar.LENGTH_SHORT).show()
                        }
                )
        subscriptions.add(subscription)
    }

    private fun initAdapter() {
        if (newsList.adapter == null)
            newsList.adapter = NewsAdapter()
    }
}