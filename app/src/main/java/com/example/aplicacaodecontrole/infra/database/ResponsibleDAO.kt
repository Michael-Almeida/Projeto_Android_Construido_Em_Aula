package com.example.aplicacaodecontrole.infra.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.aplicacaodecontrole.Model.Account
import com.example.aplicacaodecontrole.Model.Responsible

@Dao

//classe que irá conversar com as tabelas no banco de dados
interface ResponsibleDAO {

    @Insert
    suspend fun save(responsible: Responsible)

    @Delete
    suspend fun delete(responsible: Responsible)

    @Query("SELECT * FROM Responsible")
    fun getAllResponsibles(): List<Responsible>



}