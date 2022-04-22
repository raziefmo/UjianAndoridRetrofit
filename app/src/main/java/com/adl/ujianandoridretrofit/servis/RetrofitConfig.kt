package com.adl.ujianandoridretrofit.servis

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    fun getInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return okHttpClient
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.4/cicool/")//liat di cmd ipconfig
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
   fun getLogin() = getRetrofit().create(Login::class.java)
    fun getabsen() = getRetrofit().create(Login::class.java)




}