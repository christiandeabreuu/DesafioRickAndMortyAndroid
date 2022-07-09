package br.com.zup.rickandmorty.domain.usecase


import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import br.com.zup.rickandmorty.AppApplication
import br.com.zup.rickandmorty.data.local.entity.CharacterEntity
import br.com.zup.rickandmorty.domain.repository.CharacterRepository
import br.com.zup.rickandmorty.ui.viewstate.ViewState

class CharacterUseCase{
    private val characterRepository = CharacterRepository()
    private val charactersMediator = MediatorLiveData<ViewState<List<CharacterEntity>>>()

    init {
        charactersMediator.addSource(characterRepository.getAllCharactersEntityLiveData()) {
            charactersMediator.value = ViewState.Sucess(it)
        }
    }

    fun getAllCharactersEntityLiveData(): LiveData<ViewState<List<CharacterEntity>>> {
        return charactersMediator
    }

    fun onAllCharacters() {
        characterRepository.onAllCharacters()
    }

    fun update(characterEntity: CharacterEntity) {
        characterRepository.update(characterEntity)
    }

    fun getAllFavorites(): LiveData<List<CharacterEntity>> {
        return characterRepository.getAllFavorites()
    }
}