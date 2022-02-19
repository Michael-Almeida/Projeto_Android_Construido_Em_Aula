package com.example.aplicacaodecontrole.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aplicacaodecontrole.repository.LoginRepository

object LoginViewModelFactory: ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(LoginRepository()) as T
    }
}