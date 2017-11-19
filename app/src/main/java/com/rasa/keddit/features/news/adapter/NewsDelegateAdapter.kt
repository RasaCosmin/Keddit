package com.rasa.keddit.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.rasa.keddit.R
import com.rasa.keddit.commons.RedditNewsItem
import com.rasa.keddit.commons.adapter.ViewType
import com.rasa.keddit.commons.adapter.ViewTypeDelegateAdapter
import com.rasa.keddit.commons.extemsions.getFriendlyTime
import com.rasa.keddit.commons.extemsions.inflate
import com.rasa.keddit.commons.extemsions.loadImg
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * Created by cosmi on 18-Nov-17.
 */
class NewsDelegateAdapter : ViewTypeDelegateAdapter{
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item)){
        fun bind(item: RedditNewsItem) = with(itemView){
            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
        }
    }
}
