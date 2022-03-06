package com.example.aplicacaodecontrole.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aplicacaodecontrole.repository.LoginRepository

object LoginViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            val repository = LoginRepository()
            return LoginViewModel(LoginRepository()) as T
        }

        throw IllegalAccessException("Erro desconhecido")
    }
}