package `in`.iotlab.pokedeviot.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import `in`.iotlab.pokedeviot.R
import `in`.iotlab.pokedeviot.view.components.PokemonList
import `in`.iotlab.pokedeviot.view.components.SearchBar
import `in`.iotlab.pokedeviot.vm.PokemonListViewModel

@Composable
fun HomeScreen(navController: NavController,
               viewModel: PokemonListViewModel = hiltViewModel()) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            Brush.verticalGradient(
                listOf(
                    MaterialTheme.colorScheme.background,
                    Color(0x80E73820)
                )
            )
        )
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.poketitlenew),
                contentDescription = "PokeDev",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .align(CenterHorizontally)
            )
            SearchBar(
                hint = "Search...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            ) {
                navController.navigate("details_screen/${Color(0x80E73820).toArgb()}/${it.trim()}")
            }
            Spacer(modifier = Modifier.height(16.dp))
            PokemonList(navController = navController)
        }
    }
}