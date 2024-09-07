package `in`.iotlab.pokedeviot.view.components

import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import `in`.iotlab.pokedeviot.data.model.Pokemon


@Composable
fun PokemonDetailStateWrapper(
    pokemonInfo: Pokemon,
    modifier: Modifier = Modifier,
    loadingModifier: Modifier = Modifier
) {
    PokemonDetailSection(
        pokemonInfo = pokemonInfo,
        modifier = modifier
            .offset(y = (-20).dp)
    )
}