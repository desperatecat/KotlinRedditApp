package com.example.kotlinredditapp.features.news.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinredditapp.R
import com.example.kotlinredditapp.commons.RedditNewsItem
import com.example.kotlinredditapp.commons.adapter.ViewType
import com.example.kotlinredditapp.commons.adapter.ViewTypeDelegateAdapter
import com.example.kotlinredditapp.commons.extensions.inflate
import com.example.kotlinredditapp.commons.extensions.loadImg
import kotlinx.android.synthetic.main.news_item.view.*

class NewsDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.news_item)) {

        fun bind(item: RedditNewsItem) = with(itemView) {

            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title

        }
    }
}