package com.example.giphytestapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.giphytestapp.ui.navigation.Screen.DetailScreen.IMAGE_ARGS_KEY
import com.example.giphytestapp.ui.detail_screen.DetailScreen
import com.example.giphytestapp.ui.home_screen.HomeScreenViewModel
import com.example.giphytestapp.ui.home_screen.HomeScreen

@Composable
fun NavigationHost() {
    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            val viewModel: HomeScreenViewModel = hiltViewModel()
            HomeScreen(
                connectivityManagerState = viewModel.connectivity,
                giphyList = viewModel.giphyList,
                onClickListingItem = { image ->
                    navHostController.navigate(
                        route = Screen.DetailScreen.getRouteWithArgs(image = image)
                    )
                }
            )
        }
        composable(
            route = Screen.DetailScreen.getRouteWithArgs(image = IMAGE_ARGS_KEY, isOutput = true),
            arguments = listOf(
                navArgument(IMAGE_ARGS_KEY) {
                    type = NavType.StringType
                }
            )) {
            DetailScreen(
                 image = it.arguments?.getString(IMAGE_ARGS_KEY)
            )
        }
    }
}