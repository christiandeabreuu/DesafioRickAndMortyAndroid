package br.com.zup.rickandmorty.ui.home.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.zup.rickandmorty.data.local.entity.CharacterEntity
import br.com.zup.rickandmorty.data.model.CharacterResult
import br.com.zup.rickandmorty.domain.model.SingleLiveEvent
import br.com.zup.rickandmorty.domain.usecase.CharacterUseCase
import br.com.zup.rickandmorty.ui.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(application: Application) : AndroidViewModel(application){
    private val characterUseCase = CharacterUseCase()
    val characterListState: LiveData<ViewState<List<CharacterEntity>>> = characterUseCase.getAllCharactersEntityLiveData()

    fun getAllCharacters(){
        characterUseCase.onAllCharacters()
    }
}