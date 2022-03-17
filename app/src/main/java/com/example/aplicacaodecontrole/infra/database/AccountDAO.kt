package com.example.aplicacaodecontrole.infra.database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.aplicacaodecontrole.Model.Account
import com.example.aplicacaodecontrole.Model.Responsible

interface AccountDAO {

    @Insert
    suspend fun save(account: Account)

    @Delete
    suspend fun delete(account: Account)

    @Query("SELECT * FROM Account")
    fun getAllaccount(): List<Account>

}