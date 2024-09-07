package `in`.iotlab.pokedeviot.vm

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.iotlab.pokedeviot.data.model.Pokemon
import `in`.iotlab.pokedeviot.data.repo.PokemonRepository
import `in`.iotlab.pokedeviot.data.utils.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val repository: PokemonRepository) : ViewModel() {

    private val _pokemonDetails: MutableStateFlow<UiState<Pokemon>> = MutableStateFlow(UiState.Idle)
    val pokemonDetails = _pokemonDetails.asStateFlow()

    fun pokemonDetails(pokemonName: String) {
        getPokemonDetails(pokemonName = pokemonName)
    }

    private fun getPokemonDetails(pokemonName: String) {

    }
}