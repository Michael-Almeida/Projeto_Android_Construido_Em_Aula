package com.example.aplicacaodecontrole.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.math.BigDecimal

@Entity
data class Account(
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val balance: BigDecimal? = BigDecimal.ZERO,
    @ColumnInfo
    val responsible: Responsible = TODO(),

    @ColumnInfo
    val accountType: AccountTypeEnum
)





