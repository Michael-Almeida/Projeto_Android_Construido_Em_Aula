package com.example.aplicacaodecontrole.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

object ResponsableViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ResponsableActivityViewModel() as T
    }
}