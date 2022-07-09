package br.com.zup.rickandmorty.data.model


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info")
    var info: Info,
    @SerializedName("results")
    var characterResults: List<CharacterResult>
)