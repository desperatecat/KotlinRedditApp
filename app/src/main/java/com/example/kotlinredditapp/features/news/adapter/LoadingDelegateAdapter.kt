package com.example.kotlinredditapp.features.news.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinredditapp.R
import com.example.kotlinredditapp.commons.adapter.ViewType
import com.example.kotlinredditapp.commons.adapter.ViewTypeDelegateAdapter
import com.example.kotlinredditapp.commons.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.news_item_loading)) {
    }
}