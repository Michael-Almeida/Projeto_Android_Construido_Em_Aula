package com.example.aplicacaodecontrole.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.aplicacaodecontrole.repository.AccountRepository

class AccountsViewModel : ViewModel() {

    private val index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(index) {
        "Seção $it onde ficará a lista de contas"
    }

    fun setIndex(index: Int) {
        this.index.value = index
    }

    fun getAccounts() = AccountRepository().getAllAcounts()

}