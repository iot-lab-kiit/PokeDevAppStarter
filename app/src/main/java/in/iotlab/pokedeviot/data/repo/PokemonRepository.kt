package `in`.iotlab.pokedeviot.data.repo

import `in`.iotlab.pokedeviot.data.model.Pokemon
import `in`.iotlab.pokedeviot.data.model.PokemonList
import `in`.iotlab.pokedeviot.data.remote.PokeApi
import `in`.iotlab.pokedeviot.data.utils.UiState
import retrofit2.Response
import javax.inject.Inject

class PokemonRepository @Inject constructor(){

    suspend fun getPokemonList(limit: Int, offset: Int): UiState<PokemonList> {
        return UiState.Error(message = "Error")
    }

    suspend fun getPokemonInfo(pokemonName: String): UiState<Pokemon> {
        return UiState.Error(message = "Error")
    }
}