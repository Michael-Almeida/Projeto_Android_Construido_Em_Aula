package com.example.aplicacaodecontrole

import android.app.Application
import com.example.aplicacaodecontrole.infra.database.BCDatabase

class BusinessControllApplication : Application() {

    val database by lazy{BCDatabase.getDataBase(this)}

}