package com.example.aplicacaodecontrole.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aplicacaodecontrole.BusinessControllApplication
import com.example.aplicacaodecontrole.Model.Responsible
import com.example.aplicacaodecontrole.repository.ResponsibleRespository

class ResponsableViewModelFactory(private val application: BusinessControllApplication) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResponsableActivityViewModel::class.java)) {
            val responsibleDAO = application.database.responsibleDao()
            val responsibleRespository = ResponsibleRespository(responsibleDAO)

            return ResponsableActivityViewModel(responsibleRespository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}