package com.example.kotlinredditapp.api

class RedditNewsResponse(val data: RedditDataResponse)

class RedditDataResponse(
    val children: List<RedditChildrenResponse>,
    val after: String?,
    val before: String?
)

class RedditChildrenResponse(val data: RedditNewsDataResponse)

class RedditNewsDataResponse(
    val author: String,
    val title: String,
    val thumbnail: String,
    val url: String
)