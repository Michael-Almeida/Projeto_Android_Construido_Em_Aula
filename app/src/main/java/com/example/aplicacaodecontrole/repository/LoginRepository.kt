package com.example.aplicacaodecontrole.repository

import com.example.aplicacaodecontrole.Model.User
import com.example.aplicacaodecontrole.Model.Result
import kotlinx.coroutines.delay
import java.lang.Exception

class LoginRepository {

    suspend fun login(email: String, password: String): Result<User> {
        return callSimulationForService(email, password)


    }

    //simulação de chamada para serviço
    private suspend fun callSimulationForService(email: String, password: String): Result<User> {
        delay(5000)

        return when (verifyPassword(email, password)) {
            true -> Result.sucess(User(email, password))
            false -> Result.error(Exception("Email e senha inválida"))
        }
    }

    //verificação de loggin
    private fun verifyPassword(email: String, password: String): Boolean {

        val fakeUser = User("admin@admin.com", "pass")

        return email == fakeUser.email && password == fakeUser.password
    }
}