package `in`.iotlab.pokedeviot.data.model

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)