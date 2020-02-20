package com.example.kotlinredditapp.features.news


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinredditapp.R
import com.example.kotlinredditapp.commons.RedditNewsItem
import com.example.kotlinredditapp.commons.extensions.inflate

import kotlinx.android.synthetic.main.news_fragment.*
import com.example.kotlinredditapp.features.news.adapter.NewsAdapter

class NewsFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)

        initAdapter()

        if (savedInstanceState == null) {
            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) {

                news.add(RedditNewsItem(
                    "author$i",
                    "Title $i",
                    "https://picsum.photos/200/200?image=$i", // image url
                    "url"
                ))
            }
            (news_list.adapter as NewsAdapter).addNews(news)
        }

    }



    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }
}