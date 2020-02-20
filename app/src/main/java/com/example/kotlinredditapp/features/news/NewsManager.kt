package com.example.kotlinredditapp.features.news



import com.example.kotlinredditapp.commons.RedditNewsItem
import rx.Observable


class NewsManager() {

    fun getNews(): Observable<List<RedditNewsItem>> {
        return Observable.create { subscriber ->


            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) {

                news.add(
                    RedditNewsItem(
                        "author$i",
                        "Title $i",
                        "https://picsum.photos/200/200?image=$i", // image url
                        "url"
                    )
                )
            }
            subscriber.onNext(news)
        }
    }
}