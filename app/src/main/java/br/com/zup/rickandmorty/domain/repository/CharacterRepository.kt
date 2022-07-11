package br.com.zup.rickandmorty.domain.repository

import androidx.lifecycle.LiveData
import br.com.zup.rickandmorty.data.local.AppApplication
import br.com.zup.rickandmorty.data.local.entity.CharacterEntity
import br.com.zup.rickandmorty.data.remote.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class CharacterRepository {
    private val listCharacterDB = AppApplication.getDB().characterDAO().getAll()

    fun getAllCharactersEntityLiveData(): LiveData<List<CharacterEntity>> {
        return listCharacterDB
    }

    fun onAllCharacters() {
        runBlocking(Dispatchers.IO) {
            try {
                val response = RetrofitService.apiService.getAllCharactersNetwork()
                val listCharacterEntity = mutableListOf<CharacterEntity>()
                response.characterResults.forEach {
                    listCharacterEntity.add(
                        CharacterEntity(
                            id = it.id,
                            image = it.image,
                            species = it.species,
                            gender = it.gender,
                            status = it.status,
                            name = it.name,
                            favorite = false
                        )
                    )
                }
                AppApplication.getDB().characterDAO().insertAll(listCharacterEntity)

            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}