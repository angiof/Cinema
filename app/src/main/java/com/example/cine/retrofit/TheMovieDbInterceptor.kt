package com.example.cine.retrofit

import com.example.cine.comom.Constanti
import okhttp3.Interceptor
import okhttp3.Response

class TheMovieDbInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        //aggiungo i parametri della url alla catena che viene ricevuta chain
        val urlConParametri = chain.request()
            .url
            .newBuilder()
            .addQueryParameter(Constanti.URL_API_KEY_PARAM, Constanti.API_KEY)
            .addQueryParameter(Constanti.URL_PARAM_LANGUAGE, "it-It").build()


        var request = chain.request()
        request = request?.newBuilder().url(urlConParametri)
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build()


       return chain.proceed(request)
    }

}