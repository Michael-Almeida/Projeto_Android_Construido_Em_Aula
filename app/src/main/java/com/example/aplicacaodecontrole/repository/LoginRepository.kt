package com.example.aplicacaodecontrole.repository

import com.example.aplicacaodecontrole.Model.Login
import com.example.aplicacaodecontrole.Model.Result
import com.example.aplicacaodecontrole.Model.User
import com.example.aplicacaodecontrole.infra.webservice.LoginAPI
import com.example.aplicacaodecontrole.infra.webservice.LoginHttp
import java.lang.Exception

class LoginRepository {

    val loginService = LoginAPI.loginService

    suspend fun loginOld(email: String, password: String): Result<User> {
        return LoginHttp.doLogin(Login(email, password))


    }

    suspend fun login(email: String, password: String): Result<User> {
        val response = loginService.login(Login(email, password))

        return if (response.isSuccessful) {
            response.body()?.let {
                Result.Sucess(it)
            } ?: Result.Error(Exception("Retorna vazio"))
        } else {
            val responseBodyError = response.errorBody()
            Result.Error(Exception(responseBodyError?.string()))
        }

    }

//    //simulação de chamada para serviço
//    private suspend fun callSimulationForService(email: String, password: String): Result<login> {
//        delay(5000)
//
//        return when (verifyPassword(email, password)) {
//            true -> Result.sucess(login(email, password))
//            false -> Result.error(Exception("Email e senha inválida"))
//        }
//    }
//
//    //verificação de loggin
//    private fun verifyPassword(email: String, password: String): Boolean {
//
//        val fakeUser = login("admin@admin.com", "pass")
//
//        return email == fakeUser.email && password == fakeUser.password
//    }
}