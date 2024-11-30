package com.example.repaso.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.repaso.ui.theme.screens.Game
import com.example.repaso.ui.theme.screens.GameOver
import com.example.repaso.ui.theme.screens.Home

@Composable
fun AppNavigation (){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.Home.route
    ){
        composable(AppScreens.Home.route){
            Home(navController)
        }
        composable(AppScreens.Game.route){
            Game(navController)
        }
        composable(AppScreens.GameOver.route){
            GameOver(navController)
        }
    }
}