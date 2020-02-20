package com.example.kotlinredditapp.features.news


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinredditapp.R
import com.example.kotlinredditapp.commons.RedditNewsItem
import com.example.kotlinredditapp.commons.extensions.inflate

import kotlinx.android.synthetic.main.news_fragment.*
import com.example.kotlinredditapp.features.news.adapter.NewsAdapter
import com.example.kotlinredditapp.commons.RxBaseFragment
import com.google.android.material.snackbar.Snackbar
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers



class NewsFragment : RxBaseFragment() {

    private val newsManager by lazy { NewsManager() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)

        initAdapter()

        if (savedInstanceState == null) {

            requestNews()
        }

    }

    private fun requestNews(){
        val subscription = newsManager.getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                { retrievedNews ->
                    (news_list.adapter as NewsAdapter).addNews(retrievedNews)
                },
                { e ->
                    Snackbar.make(news_list, e.message ?: "", Snackbar.LENGTH_LONG).show()
                }
            )
        subscriptions.add(subscription)
    }


    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }
}