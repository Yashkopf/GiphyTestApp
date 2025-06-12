package com.example.giphytetsapp.domain.navigation

sealed class Screen(val route: String) {

    object HomeScreen: Screen("home_screen")
    object DetailScreen: Screen("detail_screen") {

        fun getRouteWithArgs(image: String, isOutput: Boolean = false): String {
            val test = if (isOutput) "{$IMAGE_ARGS_KEY}" else image
            return this.route + "?$IMAGE_ARGS_KEY=$test"
        }
        const val IMAGE_ARGS_KEY = "image"
    }
}
