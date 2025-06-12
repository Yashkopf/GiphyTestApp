package com.example.giphytetsapp.domain.navigation

sealed class Screen(val route: String) {

    object HomeScreen: Screen("home_screen")
    object DetailScreen: Screen("detail_screen") {
        fun getRouteWithArgs(image: String): String{
            return this.route + "?image={$image}"
        }
    }
}