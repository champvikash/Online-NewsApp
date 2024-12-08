package com.example.testappjetpackcompose.ui.uiscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import com.example.testappjetpackcompose.MainActivity
import com.example.testappjetpackcompose.ui.uiscreen.viewmodels.NewsViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewsArticleScreen(navController: NavHostController, mainActivity: MainActivity) {
//    SimpleCard()
    val newsTopLevelViewModel = ViewModelProvider(mainActivity)[NewsViewModel::class.java]

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(
                text = "News Now",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.Red,
                fontSize = 25.sp,
                fontFamily = FontFamily.SansSerif
            )

            NewsArticleTopLineHomePage(newsTopLevelViewModel)
        }

    }


}


@Composable
fun SimpleCard() {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp) // Rounded corners
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "This is a card")
                Text(text = "This is a card")
            }
        }

    }
}
