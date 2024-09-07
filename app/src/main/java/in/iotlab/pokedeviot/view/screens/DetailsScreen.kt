package `in`.iotlab.pokedeviot.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import `in`.iotlab.pokedeviot.R
import `in`.iotlab.pokedeviot.data.utils.UiState
import `in`.iotlab.pokedeviot.view.components.PokemonDetailStateWrapper
import `in`.iotlab.pokedeviot.view.components.PokemonDetailTopSection
import `in`.iotlab.pokedeviot.view.components.ShimmerImage
import `in`.iotlab.pokedeviot.vm.PokemonDetailsViewModel

@Composable
fun DetailsScreen(
    dominantColor: Color = Color(0x80E73820),
    pokemonName: String,
    navController: NavController,
    topPadding: Dp = 50.dp,
    pokemonImageSize: Dp = 200.dp,
    viewModel: PokemonDetailsViewModel = hiltViewModel()) {

    val loadingComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.pokeball_loading))
    val noDataComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.no_data_found_anim))

    Box(modifier = Modifier
        .fillMaxSize()
        .background(dominantColor)
        .padding(bottom = 16.dp)
    ) {
        val data = viewModel.pokemonDetails.collectAsState().value
        when(data)
        {
            is UiState.Idle -> {
                viewModel.pokemonDetails(pokemonName)
            }
            is UiState.Loading -> {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    LottieAnimation(composition = loadingComposition,
                        modifier = Modifier.size(128.dp),
                        contentScale = ContentScale.Fit,
                        iterations = LottieConstants.IterateForever)
                }
            }
            is UiState.Success -> {
                PokemonDetailTopSection(
                    navController = navController,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.2f)
                        .align(Alignment.TopCenter)
                )
                PokemonDetailStateWrapper(
                    pokemonInfo = data.data,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            top = topPadding + pokemonImageSize / 2f,
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 16.dp
                        )
                        .shadow(10.dp, RoundedCornerShape(10.dp))
                        .clip(RoundedCornerShape(16.dp))
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                        .align(Alignment.BottomCenter),
                    loadingModifier = Modifier
                        .size(100.dp)
                        .align(Alignment.Center)
                        .padding(
                            top = topPadding + pokemonImageSize / 2f,
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 16.dp
                        )
                )
                Box(contentAlignment = Alignment.TopCenter,
                    modifier = Modifier
                        .fillMaxSize()) {
                    ShimmerImage(imgUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${data.data.id}.png",
                        modifier = Modifier
                            .size(pokemonImageSize)
                            .offset(y = topPadding))
                }
            }
            else -> {
                Column(
                    modifier = Modifier.fillMaxHeight().fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    LottieAnimation(composition = noDataComposition,
                        modifier = Modifier.size(240.dp),
                        contentScale = ContentScale.Fit,
                        iterations = LottieConstants.IterateForever)
                }
            }
        }
    }
}