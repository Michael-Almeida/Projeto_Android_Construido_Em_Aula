package com.example.aplicacaodecontrole.Model

import java.math.BigDecimal

data class Account(
    val name: String,
    val valance: BigDecimal, val responsible: Responsible, val accountType: AccountTypeEnum
)


