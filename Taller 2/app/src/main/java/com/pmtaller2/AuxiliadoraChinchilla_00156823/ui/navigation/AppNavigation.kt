package com.pmtaller2.AuxiliadoraChinchilla_00156823.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pmtaller2.AuxiliadoraChinchilla_00156823.ui.Screens.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HomeScreen,
    ) {
        composable<HomeScreen> {
            HomeScreen(navController = navController)
        }
        composable<SearchScreen>{

        }
        composable<OrdersScreen>{

        }
        composable<MenuScreen>{

        }
//        composable <MovieDetailScreenNavigation> { backStackEntry ->
//            val movieId = backStackEntry.arguments?.getInt("id") ?: 0
//            MovieDetailScreen(movieId = movieId)
//        }
    }
}