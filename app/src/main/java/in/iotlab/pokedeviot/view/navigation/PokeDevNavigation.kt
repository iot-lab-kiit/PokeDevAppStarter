package `in`.iotlab.pokedeviot.view.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import `in`.iotlab.pokedeviot.view.screens.DetailsScreen
import `in`.iotlab.pokedeviot.view.screens.HomeScreen

@Composable
fun PokeDevNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = PokeDevScreens.HomeScreen.route
    ) {
        composable(PokeDevScreens.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable("details_screen/{dominantColor}/{pokemonName}",
            arguments = listOf(
                navArgument("dominantColor") {
                    type = NavType.IntType
                },
                navArgument("pokemonName") {
                    type = NavType.StringType
                }
            )
        ) {
            val dominantColor = remember {
                val color = it.arguments?.getInt("dominantColor")
                color?.let { Color(it) } ?: Color.White
            }
            val pokemonName = remember {
                it.arguments?.getString("pokemonName")
            }
            DetailsScreen(
                dominantColor = dominantColor,
                pokemonName = pokemonName?.lowercase() ?: "",
                navController)
        }
    }
}