package com.example.kotlinredditapp.commons

import com.example.kotlinredditapp.commons.adapter.AdapterConstants
import com.example.kotlinredditapp.commons.adapter.ViewType

data class RedditNewsItem(
    val author: String,
    val title: String,
    val thumbnail: String,
    val url: String
): ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}