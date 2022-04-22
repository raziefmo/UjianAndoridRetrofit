package com.adl.ujianandoridretrofit.servis

import com.adl.ujianandoridretrofit.model.ResponsePostData
import retrofit2.Call
import retrofit2.http.*

interface Login {
    //ambil get
    @Headers("X-Api-Key:C1B5A29AB04F4C1C5AAE44AFF305ECA5")
    @GET("api/ujian/all")
    fun getAllLogin(): Call<ResponsePostData>

    @FormUrlEncoded
    @Headers("X-Api-Key:C1B5A29AB04F4C1C5AAE44AFF305ECA5")
    @POST("api/ujian/add")
    fun addData(@Field("username") username:String, @Field("password")password:String): Call<ResponsePostData>
}