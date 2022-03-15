package com.example.aplicacaodecontrole.Model

import java.lang.Exception

//Define classe de retorno, cria-se quando quer encapsular o retorno da api, tratar erros e sucessos
sealed class Result<out T> {

    data class Sucess<out T>(val data: T) : Result<T>()

    data class Error (val exception: Exception): Result<Nothing>()
}