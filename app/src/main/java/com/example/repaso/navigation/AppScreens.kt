package com.example.repaso.navigation;

sealed class AppScreens(val route: String) {

    object Home : AppScreens("home_screen")
    object Game : AppScreens("game_screen")
    object GameOver : AppScreens("game_over")

}