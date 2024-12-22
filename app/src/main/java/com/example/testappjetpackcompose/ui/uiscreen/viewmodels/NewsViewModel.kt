package com.example.testappjetpackcompose.ui.uiscreen.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testappjetpackcompose.Constant
import com.kwabenaberko.newsapilib.NewsApiClient
import com.kwabenaberko.newsapilib.models.Article
import com.kwabenaberko.newsapilib.models.request.EverythingRequest
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest
import com.kwabenaberko.newsapilib.models.response.ArticleResponse
import retrofit2.http.Query

class NewsViewModel() : ViewModel() {

    private val _article = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _article


    init {
        fetchNewsHeadLine()
    }


    fun fetchNewsHeadLine(category: String = "GENERAL") {
        val newsApiClient = NewsApiClient(Constant.apikey)

        val request = TopHeadlinesRequest.Builder().language("en").category(category).build()

        newsApiClient.getTopHeadlines(request, object : NewsApiClient.ArticlesResponseCallback {
            override fun onSuccess(response: ArticleResponse?) {
                response?.articles?.let {
                    _article.postValue(it)
                }
            }

            override fun onFailure(throwable: Throwable?) {
                if (throwable != null) {

                }

            }
        })
    }


    fun fetchEveryThing(query: String) {
        val newsApiClient = NewsApiClient(Constant.apikey)

        val request = EverythingRequest.Builder().language("en").q(query).build()

        newsApiClient.getEverything(request, object : NewsApiClient.ArticlesResponseCallback {
            override fun onSuccess(response: ArticleResponse?) {
                response?.articles?.let {
                    _article.postValue(it)
                }
            }

            override fun onFailure(throwable: Throwable?) {
                if (throwable != null) {

                }

            }
        })
    }


}