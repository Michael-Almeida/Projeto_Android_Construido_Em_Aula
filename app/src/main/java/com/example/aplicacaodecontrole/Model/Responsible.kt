package com.example.aplicacaodecontrole.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Responsible(@ColumnInfo val name: String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var idResponsible: Int? = null
}