package `in`.iotlab.pokedeviot.data.utils

import androidx.compose.ui.graphics.Color
import `in`.iotlab.pokedeviot.data.model.Stat
import `in`.iotlab.pokedeviot.data.model.Type
import `in`.iotlab.pokedeviot.ui.theme.AtkColor
import `in`.iotlab.pokedeviot.ui.theme.DefColor
import `in`.iotlab.pokedeviot.ui.theme.HPColor
import `in`.iotlab.pokedeviot.ui.theme.SpAtkColor
import `in`.iotlab.pokedeviot.ui.theme.SpDefColor
import `in`.iotlab.pokedeviot.ui.theme.SpdColor
import `in`.iotlab.pokedeviot.ui.theme.TypeBug
import `in`.iotlab.pokedeviot.ui.theme.TypeDark
import `in`.iotlab.pokedeviot.ui.theme.TypeDragon
import `in`.iotlab.pokedeviot.ui.theme.TypeElectric
import `in`.iotlab.pokedeviot.ui.theme.TypeFairy
import `in`.iotlab.pokedeviot.ui.theme.TypeFighting
import `in`.iotlab.pokedeviot.ui.theme.TypeFire
import `in`.iotlab.pokedeviot.ui.theme.TypeFlying
import `in`.iotlab.pokedeviot.ui.theme.TypeGhost
import `in`.iotlab.pokedeviot.ui.theme.TypeGrass
import `in`.iotlab.pokedeviot.ui.theme.TypeGround
import `in`.iotlab.pokedeviot.ui.theme.TypeIce
import `in`.iotlab.pokedeviot.ui.theme.TypeNormal
import `in`.iotlab.pokedeviot.ui.theme.TypePoison
import `in`.iotlab.pokedeviot.ui.theme.TypePsychic
import `in`.iotlab.pokedeviot.ui.theme.TypeRock
import `in`.iotlab.pokedeviot.ui.theme.TypeSteel
import `in`.iotlab.pokedeviot.ui.theme.TypeWater
import java.util.Locale

fun parseTypeToColor(type: Type): Color {
    return when(type.type.name.lowercase()) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "electric" -> TypeElectric
        "grass" -> TypeGrass
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

fun parseStatToColor(stat: Stat): Color {
    return when(stat.stat.name.lowercase()) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: Stat): String {
    return when(stat.stat.name.lowercase()) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}