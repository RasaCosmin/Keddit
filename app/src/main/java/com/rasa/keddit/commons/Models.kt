package com.rasa.keddit.commons

import android.os.Parcel
import android.os.Parcelable
import com.rasa.keddit.commons.adapter.AdapterConstants
import com.rasa.keddit.commons.adapter.ViewType

/**
 * Created by cosmi on 18-Nov-17.
 */

data class RedditNews(
        val after: String,
        val before: String,
        val news: List<RedditNewsItem>
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.createTypedArrayList(RedditNewsItem.CREATOR)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(after)
        parcel.writeString(before)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RedditNews> {
        override fun createFromParcel(parcel: Parcel): RedditNews {
            return RedditNews(parcel)
        }

        override fun newArray(size: Int): Array<RedditNews?> {
            return arrayOfNulls(size)
        }
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

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readLong(),
            parcel.readString(),
            parcel.readString()) {
    }

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

    companion object CREATOR : Parcelable.Creator<RedditNewsItem> {
        override fun createFromParcel(parcel: Parcel): RedditNewsItem {
            return RedditNewsItem(parcel)
        }

        override fun newArray(size: Int): Array<RedditNewsItem?> {
            return arrayOfNulls(size)
        }
    }
}
