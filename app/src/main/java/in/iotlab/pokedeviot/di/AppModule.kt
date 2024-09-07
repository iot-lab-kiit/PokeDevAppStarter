package `in`.iotlab.pokedeviot.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import `in`.iotlab.pokedeviot.data.remote.PokeApi
import `in`.iotlab.pokedeviot.data.repo.PokemonRepository
import `in`.iotlab.pokedeviot.data.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

}