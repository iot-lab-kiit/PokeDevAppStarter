package `in`.iotlab.pokedeviot.view.navigation

sealed class PokeDevScreens(val route: String) {
    object HomeScreen : PokeDevScreens("home_screen")
    object DetailsScreen : PokeDevScreens("details_screen")
}