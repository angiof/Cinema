package com.example.cine.retrofit

import com.example.cine.comom.Constanti
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TheMovieDbClient {

    private val theMovieDbService: TheMovieDBService
    private val retrofit: Retrofit

    companion object {
        var instance: TheMovieDbClient? = null
            get() {
                if (field == null) {
                    instance = TheMovieDbClient()
                }
                return instance

            }
    }

    init {
        //includere intercepor per le petizioni
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(TheMovieDbInterceptor())
        val cliente = okHttpClientBuilder.build()
        //costruire retrofit cliente
        retrofit = Retrofit.Builder()
            .baseUrl(Constanti.TMDB_URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(cliente)
            .build()
        //intanziare il servizio retro da obj  retrofit
        theMovieDbService = retrofit.create(TheMovieDBService::class.java)
    }

    fun getTheMovieDbServices() = theMovieDbService

}