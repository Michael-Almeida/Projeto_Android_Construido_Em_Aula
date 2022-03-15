package com.example.aplicacaodecontrole.infra.webservice

import com.example.aplicacaodecontrole.Model.Login
import com.example.aplicacaodecontrole.Model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("v1/login")
    suspend fun login(@Body login: Login): Response<User>
}