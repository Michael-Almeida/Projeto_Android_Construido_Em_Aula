package com.example.aplicacaodecontrole.repository

import androidx.annotation.WorkerThread
import com.example.aplicacaodecontrole.Model.Account
import com.example.aplicacaodecontrole.Model.AccountTypeEnum
import com.example.aplicacaodecontrole.Model.Responsible
import com.example.aplicacaodecontrole.infra.database.AccountDAO
import com.example.aplicacaodecontrole.infra.database.ResponsibleDAO
import java.math.BigDecimal

class AccountRepository(private val accountDAO: AccountDAO) {

    fun getAllAcounts(): MutableList<Account> {
        val responsible = Responsible("Fake Responsible")

        val list = mutableListOf<Account>()

        for (i in 0..100) {
            list.add(
                Account("Banco $i ", BigDecimal.TEN, responsible, AccountTypeEnum.DEBITO),
            )
        }

        return mutableListOf(

            Account("Banco 2 ", BigDecimal.valueOf(1000), responsible, AccountTypeEnum.DEBITO)
        )
    }

    @WorkerThread
    suspend fun save(account: Account) {
        accountDAO.save(account)
    }
}