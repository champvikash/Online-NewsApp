package com.example.testappjetpackcompose.myApp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.testappjetpackcompose.MainActivity
import com.example.testappjetpackcompose.ui.uiscreen.BriefNews
import com.example.testappjetpackcompose.ui.uiscreen.LoginScreen
import com.example.testappjetpackcompose.ui.uiscreen.NewsArticleScreen
import com.example.testappjetpackcompose.ui.uiscreen.RegisterScreen
import com.example.testappjetpackcompose.ui.uiscreen.SplashScreen
import com.google.firebase.auth.FirebaseAuth


@Composable
fun MyApp(mainActivity: MainActivity, auth: FirebaseAuth) {
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "first") {
        composable("first") { SplashScreen(navController) }
        composable("second") { RegisterScreen(navController , mainActivity , auth) }
        composable("third") { LoginScreen(navController) }
        composable("four") { NewsArticleScreen(navController, mainActivity) }
        composable(
            "fifth/{pos}",
            arguments = listOf(navArgument("pos") { type = NavType.IntType }
            )
        ) {
            navBackStackEntry ->
            val pos = navBackStackEntry.arguments?.getInt("pos")?: 0
            BriefNews(mainActivity , pos)
        }
    }

}