package com.rasa.keddit.commons.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup


/**
 * Created by cosmi on 18-Nov-17.
 */
interface ViewTypeDelegateAdapter{
    fun onCreateViewHolder(parent: ViewGroup):RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}