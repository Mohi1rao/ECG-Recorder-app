package com.example.hisdemo.webservice.retrofitclient

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    lateinit var RETROFIT_CLIENT: API

    fun get(): API = RETROFIT_CLIENT

    fun setUpRetrofitClient(context: Context) {

        val retrofit = Retrofit.Builder()
            .baseUrl("http://aws-synex.jy.digital/synex/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            //  .client(fetchHeaders(context))
            .build()
        RETROFIT_CLIENT = retrofit.create(API::class.java)
    }

}
