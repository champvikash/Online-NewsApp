package com.example.testappjetpackcompose.ui.uiscreen

import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.testappjetpackcompose.ui.uiscreen.viewmodels.NewsViewModel
import com.kwabenaberko.newsapilib.models.Article

@Composable
fun NewsArticleTopLineHomePage(
    newsTopLevelViewModel: NewsViewModel,
    navController: NavHostController
) {

    val articles by newsTopLevelViewModel.articles.observeAsState(emptyList())

    val list = listOf(
        "GENERAL", "BUSINESS", "ENTERTAINMENT", "HEALTH", "SCIENCE", "SPORTS", "TECHNOLOGY"
    )

    CatListButton(list, newsTopLevelViewModel)


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(articles ) { index , article ->
                ArticleItem(article, navController, index)
            }
        }
    }
}


@Composable
fun CatListButton(list: List<String>, newsTopLevelViewModel: NewsViewModel) {

    var searchQuery by remember {
        mutableStateOf("")
    }


    var isSearchExpanded by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (isSearchExpanded) {
            OutlinedTextField(modifier = Modifier
                .padding(8.dp)
                .height(48.dp)
                .border(1.dp, Color.Gray, CircleShape),
                value = searchQuery, onValueChange = {
                    searchQuery = it
                }, trailingIcon = {
                    IconButton(onClick = {
                        isSearchExpanded = false
                        if (searchQuery.isNotEmpty()) {
                            newsTopLevelViewModel.fetchEveryThing(searchQuery)
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Search, "Search Icon")
                    }
                })

        } else {
            IconButton(onClick = {
                isSearchExpanded = true
            }) {
                Icon(imageVector = Icons.Default.Search, "Search Icon")
            }
        }

        list.forEach { category ->
            Button(onClick = {
                newsTopLevelViewModel.fetchNewsHeadLine(category)
            }, modifier = Modifier.padding(4.dp)) {
                Text(category)
            }
        }
    }
}

@Composable
fun ArticleItem(article: Article, navController: NavHostController, index: Int) {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        onClick = {
            navController.navigate("fifth/$index")
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                article.urlToImage
                    ?: "https://png.pngtree.com/png-vector/20190820/ourmid/pngtree-no-image-vector-illustration-isolated-png-image_1694547.jpg",
                contentDescription = "Article Image",
                modifier = Modifier
                    .size(80.dp)
                    .aspectRatio(1f)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 8.dp)
            ) {
                Text(text = article.title, fontWeight = FontWeight.Bold, maxLines = 3)
                Text(text = article.source.name, fontSize = 12.sp, maxLines = 1)
                Text(text = article.publishedAt, fontSize = 12.sp, maxLines = 2)
            }

        }
    }

}
