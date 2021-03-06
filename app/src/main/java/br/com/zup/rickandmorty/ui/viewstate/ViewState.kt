package br.com.zup.rickandmorty.ui.viewstate

sealed class ViewState<out T> {
    data class Sucess<T>(val data: T) : ViewState<T>()
    data class Error(val throwable: Throwable) : ViewState<Nothing>()

}