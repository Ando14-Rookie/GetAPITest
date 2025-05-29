package com.example.retrofitapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresAPI {

    @GET("api/users")
    fun getData(@Query("page") page: Int): Call<UserResponse>

}