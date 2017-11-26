package com.rasa.keddit.commons

import android.os.Parcel
import android.os.Parcelable
import com.rasa.keddit.commons.adapter.AdapterConstants
import com.rasa.keddit.commons.adapter.ViewType
import com.rasa.keddit.commons.extemsions.createParcel

/**
 * Created by cosmi on 18-Nov-17.
 */

data class RedditNews(
        val after: String,
        val before: String,
        val news: List<RedditNewsItem>) : Parcelable {

    protected constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            mutableListOf<RedditNewsItem>().apply {
                parcel.readTypedList(this, RedditNewsItem.CREATOR)
            }
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(after)
        parcel.writeString(before)
        parcel.writeTypedList(news)
    }

    override fun describeContents() = 0

    companion object {
        @JvmField @Suppress("unused")
        val CREATOR = createParcel { RedditNews(it) }
    }

}

data class RedditNewsItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : ViewType, Parcelable {

    protected constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readLong(),
            parcel.readString(),
            parcel.readString()
    )

    override fun getViewType() = AdapterConstants.NEWS

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(author)
        parcel.writeString(title)
        parcel.writeInt(numComments)
        parcel.writeLong(created)
        parcel.writeString(thumbnail)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField @Suppress("unused")
        val CREATOR = createParcel { RedditNewsItem(it) }
    }
}
