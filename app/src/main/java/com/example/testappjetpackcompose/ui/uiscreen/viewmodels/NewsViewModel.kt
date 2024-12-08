package com.example.testappjetpackcompose.ui.uiscreen.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testappjetpackcompose.Constant
import com.kwabenaberko.newsapilib.NewsApiClient
import com.kwabenaberko.newsapilib.models.Article
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest
import com.kwabenaberko.newsapilib.models.response.ArticleResponse

class NewsViewModel() : ViewModel() {

    private val _article = MutableLiveData<List<Article>>()
    val articles : LiveData<List<Article>> = _article


    init {
        fetchNewsHeadLine()
    }


    fun fetchNewsHeadLine() {
        val newsApiClient = NewsApiClient(Constant.apikey)

        val request = TopHeadlinesRequest.Builder().language("en").build()

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


}