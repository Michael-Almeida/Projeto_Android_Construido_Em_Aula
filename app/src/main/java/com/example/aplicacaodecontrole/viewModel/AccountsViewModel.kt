package com.example.aplicacaodecontrole.viewModel

import androidx.databinding.Bindable
import androidx.lifecycle.*
import com.example.aplicacaodecontrole.Model.Account
import com.example.aplicacaodecontrole.Model.AccountTypeEnum
import com.example.aplicacaodecontrole.Model.Responsible
import com.example.aplicacaodecontrole.repository.AccountRepository
import kotlinx.coroutines.launch
import java.math.BigDecimal

class AccountsViewModel(val accountRepository: AccountRepository) : BaseViewModel() {

    private val index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(index) {
        "Seção $it onde ficará a lista de contas"
    }

    fun setIndex(index: Int) {
        this.index.value = index
    }

    //fun getAccounts() = AccountRepository().getAllAcounts()

    //salvando responsavel
    @Bindable
    var name: String = ""

    @Bindable
    var balance: BigDecimal = BigDecimal.ZERO

    @Bindable
    var responsible = Responsible(name)

    @Bindable
    var accountType = AccountTypeEnum.DEBITO

    fun saveAccout() = viewModelScope.launch {
        val account = Account(name, balance, responsible, accountType)

        accountRepository.save(account)
    }
}