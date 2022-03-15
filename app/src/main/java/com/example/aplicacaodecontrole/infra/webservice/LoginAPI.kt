package com.example.aplicacaodecontrole.infra.webservice

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoginAPI {
    private const val API_BASE_URL = "https://business-controll-backend.herokuapp.com"

    private val okHttpClient: OkHttpClient by lazy {
        val client = OkHttpClient.Builder()

        client.addInterceptor(provideLoggingInterceptor())
        client.build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder() //chama para construir um objeto
            .baseUrl(API_BASE_URL) //Qual biblio irá receber o obj.
            .addConverterFactory(GsonConverterFactory.create()) //qual biblio irá converter em json
            .build()
    }

    //passando o enterpoint
    val loginService: LoginService by lazy {
        retrofit.create(LoginService::class.java)
    }

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor{
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        return logger
    }

}