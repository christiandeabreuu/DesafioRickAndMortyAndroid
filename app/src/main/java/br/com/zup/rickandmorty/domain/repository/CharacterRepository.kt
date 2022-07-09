package br.com.zup.rickandmorty.domain.repository

import androidx.lifecycle.LiveData
import br.com.zup.rickandmorty.AppApplication
import br.com.zup.rickandmorty.data.local.entity.CharacterEntity
import br.com.zup.rickandmorty.data.remote.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class CharacterRepository {
    private val listCharacterDB = AppApplication.getDB().characterDAO().getAll()
    private val listCharacterFavorites = AppApplication.getDB().characterDAO().getAllFavorites()

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

    fun update(characterEntity: CharacterEntity) {
        AppApplication.getDB().characterDAO().update(characterEntity)
    }

    fun getAllFavorites(): LiveData<List<CharacterEntity>> {
        return listCharacterFavorites
    }
}