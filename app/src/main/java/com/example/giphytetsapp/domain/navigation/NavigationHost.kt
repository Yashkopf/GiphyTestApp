package com.example.giphytetsapp.domain.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.giphytetsapp.ui.detail_screen.DetailScreen
import com.example.giphytetsapp.ui.detail_screen.DetailScreenViewModel
import com.example.giphytetsapp.ui.home_screen.HomeScreenViewModel
import com.example.giphytetsapp.ui.home_screen.HomeScreen

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
                giphyList = viewModel.giphyList,
                onClickListingItem = { image ->
                    navHostController.navigate(
                        route = Screen.DetailScreen.route + "?image=$image"
                    )
                }
            )
        }
        composable(
            route = Screen.DetailScreen.getRouteWithArgs("image"),
            arguments = listOf(
                navArgument("image") {
                    type = NavType.StringType
                }
            )) {
            val viewModel: DetailScreenViewModel = hiltViewModel()
            DetailScreen(
                uiState = viewModel.state.value,
                onGetScreenArgs = {
                    viewModel.getGiphyItem(
                        image = it.arguments?.getString("image") ?: ""
                    )
                }
            )
        }
    }
}