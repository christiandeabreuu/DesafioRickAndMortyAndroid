package br.com.zup.rickandmorty.data.remote

import br.com.zup.rickandmorty.data.model.CharacterResponse
import retrofit2.http.GET

interface CharacterAPI {
    @GET ("character")
   suspend fun getAllCharactersNetwork(): CharacterResponse
}