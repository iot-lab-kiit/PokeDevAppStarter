package `in`.iotlab.pokedeviot.vm

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import `in`.iotlab.pokedeviot.data.model.PokedexListEntry
import `in`.iotlab.pokedeviot.data.repo.PokemonRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private var curPage = 0

    var pokemonList = mutableStateOf<List<PokedexListEntry>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)

    var isSearching = mutableStateOf(false)

    init {
        loadPokemonPaginated()
    }
    
    fun loadPokemonPaginated() {

    }
}
