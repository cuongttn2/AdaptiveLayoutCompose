package com.example.adaptivelayoutcompose.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.adaptivelayoutcompose.data.DataProvider
import com.example.adaptivelayoutcompose.data.Sweets
import com.example.adaptivelayoutcompose.ui.screen.SweetsDetails
import com.example.adaptivelayoutcompose.ui.screen.SweetsFeed

@Composable
fun FeedSampleApp(windowSizeClass: WindowSizeClass) {
    val navController = rememberNavController()
    val router = Router(navController)
    NavHost(navController = navController, startDestination = "/") {
        composable(Destination.Feed.path) {
            SweetsFeed(windowSizeClass = windowSizeClass) {
                router.showSweets(it)
            }
        }
        composable(
            Destination.Details.path,
            arguments = listOf(navArgument("sweetsId") { type = NavType.IntType })
        ) {
            val selectedSweetsId = it.arguments?.getInt("sweetsId") ?: 0
            SweetsDetails(
                sweets = DataProvider.getSweetsById(selectedSweetsId),
                windowSizeClass = windowSizeClass
            ) {
                navController.popBackStack()
            }
        }
    }
}

private sealed interface Destination {
    val base: String
    val path: String

    object Feed : Destination {
        override val base: String = "/"
        override val path: String = base
    }

    object Details : Destination {
        override val base: String = "/show"
        override val path: String = "$base/{sweetsId}"
    }
}

private class Router(val navController: NavController) {
    fun showSweets(sweets: Sweets) {
        navController.navigate("${Destination.Details.base}/${sweets.id}")
    }
}