package com.example.retrofitapi

import retrofit2.Call
import retrofit2.http.GET

interface ReqresAPI {

    @GET("data")
    fun getData(): Call<List<DataAPI>>

}