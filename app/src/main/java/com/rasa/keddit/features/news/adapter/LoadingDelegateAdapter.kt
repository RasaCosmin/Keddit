package com.rasa.keddit.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.rasa.keddit.R
import com.rasa.keddit.commons.adapter.ViewType
import com.rasa.keddit.commons.adapter.ViewTypeDelegateAdapter
import com.rasa.keddit.commons.extemsions.inflate

/**
 * Created by cosmi on 18-Nov-17.
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder =
        TurnsViewHolder(parent)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) :
            RecyclerView.ViewHolder(
                    parent.inflate(R.layout.news_item_loading))
}