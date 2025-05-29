package com.example.retrofitapi

import com.google.gson.annotations.SerializedName

data class DataAPI (
    @SerializedName("id")
    var id:Int,
    @SerializedName("email")
    var email:String,
    @SerializedName("first_name")
    var firstName:String,
    @SerializedName("last_name")
    var lastName:String,
    @SerializedName("avatar")
    var avatar:String
)

data class UserResponse (
    @SerializedName("data")
    var data:List<DataAPI>
)