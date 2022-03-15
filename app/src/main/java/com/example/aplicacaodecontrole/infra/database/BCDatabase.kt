package com.example.aplicacaodecontrole.infra.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aplicacaodecontrole.Model.Responsible

@Database(entities = [Responsible::class], version = 1)
abstract class BCDatabase : RoomDatabase() {

    abstract fun responsibleDao() : ResponsibleDAO

    companion object {

        @Volatile
        private var INSTANCE: BCDatabase? = null

        fun getDataBase(context: Context): BCDatabase {
            //INSTANCE garante que abra apenas uma conexão com o BD
            return INSTANCE ?: synchronized(true) {
                //cria a conexão
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BCDatabase::class.java,
                    "BCDatabase"
                ).build()

                INSTANCE = instance
                instance
            }
        }

    }
}