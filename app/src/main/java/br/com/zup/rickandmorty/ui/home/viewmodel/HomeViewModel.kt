package br.com.zup.rickandmorty.ui.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import br.com.zup.rickandmorty.data.local.entity.CharacterEntity
import br.com.zup.rickandmorty.domain.usecase.CharacterUseCase
import br.com.zup.rickandmorty.ui.viewstate.ViewState

class HomeViewModel(application: Application) : AndroidViewModel(application){
    private val characterUseCase = CharacterUseCase()
    val characterListState: LiveData<ViewState<List<CharacterEntity>>> = characterUseCase.getAllCharactersEntityLiveData()

    fun getAllCharacters(){
        characterUseCase.onAllCharacters()
    }
}