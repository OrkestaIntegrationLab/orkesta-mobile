package com.norkut.orkestapp.common.network

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiServiceFactory  @Inject constructor(
    private val client : OkHttpClient,
    private val gson : Gson
){
    fun <Api> create(apiClass: Class<Api>, baseUrl: String): Api =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(apiClass)
}