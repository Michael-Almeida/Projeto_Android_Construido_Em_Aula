package com.example.aplicacaodecontrole.repository

import androidx.annotation.WorkerThread
import com.example.aplicacaodecontrole.Model.Responsible
import com.example.aplicacaodecontrole.infra.database.ResponsibleDAO

class ResponsibleRespository (private val responsibleDAO: ResponsibleDAO) {

    @WorkerThread
    suspend fun save(responsible: Responsible){
        responsibleDAO.save(responsible)
    }
}