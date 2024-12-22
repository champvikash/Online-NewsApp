package com.example.testappjetpackcompose.ui.uiscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import coil.compose.AsyncImage
import com.example.testappjetpackcompose.MainActivity
import com.example.testappjetpackcompose.ui.uiscreen.viewmodels.NewsViewModel

@Composable
fun BriefNews(mainActivity: MainActivity, pos: Int) {
    val newsTopLevelViewModel = ViewModelProvider(mainActivity)[NewsViewModel::class.java]
    val articles by newsTopLevelViewModel.articles.observeAsState(emptyList())


    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {


            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Cyan)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {

                    Text(
                        text = "News Now",
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        color = Color.Red,
                        fontSize = 25.sp,
                        fontFamily = FontFamily.SansSerif
                    )

                    Spacer(modifier = Modifier.fillMaxHeight(.01f))


                    Text(
                        text = articles[pos].title,
                        Modifier.padding(8.dp),
                        fontWeight = FontWeight.Bold,
                        maxLines = 3
                    )

                    Spacer(modifier = Modifier.fillMaxHeight(.01f))


                    AsyncImage(
                        articles[pos].urlToImage
                            ?: "https://png.pngtree.com/png-vector/20190820/ourmid/pngtree-no-image-vector-illustration-isolated-png-image_1694547.jpg",
                        contentDescription = "Article Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(.5f)
                            .clip(shape = RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.fillMaxHeight(.1f))
                    Text(
                        text = articles[pos].description,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red,
                        fontSize = 25.sp


                        )

                    Spacer(modifier = Modifier.fillMaxHeight(.01f))

                    Text(
                        text = articles[pos].publishedAt,
                        fontWeight = FontWeight.Bold,
                        maxLines = 3,
                    )
                    Spacer(modifier = Modifier.fillMaxHeight(.01f))

                    Text(text = articles[pos].author, fontWeight = FontWeight.Bold, maxLines = 3)


                }

            }
        }

    }
}