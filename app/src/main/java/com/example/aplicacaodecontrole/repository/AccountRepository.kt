package com.example.aplicacaodecontrole.repository

import com.example.aplicacaodecontrole.Model.Account
import com.example.aplicacaodecontrole.Model.AccountTypeEnum
import com.example.aplicacaodecontrole.Model.Responsible
import java.math.BigDecimal

class AccountRepository {

    fun getAllAcounts(): MutableList<Account> {
        val responsible = Responsible("Fake Responsible")

        val list = mutableListOf<Account>()

        for (i in 0..100){
            list.add(
                Account("Banco $i ", BigDecimal.TEN, responsible, AccountTypeEnum.DEBITO),
            )
        }

        return mutableListOf(

            Account("Banco 2 ", BigDecimal.valueOf(1000), responsible, AccountTypeEnum.DEBITO)
        )
    }
}