package com.example.testappjetpackcompose.myApp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testappjetpackcompose.MainActivity
import com.example.testappjetpackcompose.ui.uiscreen.LoginScreen
import com.example.testappjetpackcompose.ui.uiscreen.NewsArticleScreen
import com.example.testappjetpackcompose.ui.uiscreen.RegisterScreen
import com.example.testappjetpackcompose.ui.uiscreen.SplashScreen

@Composable
fun MyApp(mainActivity: MainActivity) {
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "first") {
        composable("first") { SplashScreen(navController) }
        composable("second") { RegisterScreen(navController) }
        composable("third") { LoginScreen(navController) }
        composable("four") { NewsArticleScreen(navController , mainActivity) }
    }

}