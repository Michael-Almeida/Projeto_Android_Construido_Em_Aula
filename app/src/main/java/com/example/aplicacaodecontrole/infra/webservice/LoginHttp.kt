package com.example.aplicacaodecontrole.infra.webservice

import com.example.aplicacaodecontrole.Model.Result
import com.example.aplicacaodecontrole.Model.User
import com.example.aplicacaodecontrole.Model.Login
import com.google.gson.Gson
import java.io.InputStreamReader
import java.io.Reader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

object LoginHttp {
    private const val loginUrl = "https://business-controll-backend.herokuapp.com/v1/login"

    private val gson: Gson = Gson()

    suspend fun doLogin(login: Login): Result<User> {
        //formará o link que queremos acessar.
        val url = URL(loginUrl)

        (url.openConnection() as? HttpURLConnection)?.run {
            requestMethod = "POST"
            setRequestProperty("Content-Type", "application/json; utf-8")
            setRequestProperty("Acept", "application/json")

            doOutput = true

            outputStream.write(gson.toJson(login).toByteArray())

            val reader: Reader = InputStreamReader(inputStream, "utf-8")

            val usuario = gson.fromJson(reader, User::class.java)

            return Result.Sucess(usuario)
        }
        return Result.Error(Exception("Não foi possível iniciar uma conexão com a internet"))
    }
}