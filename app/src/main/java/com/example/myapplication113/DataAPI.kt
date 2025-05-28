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
    @SerializedName("page")
    var page:Int,
    @SerializedName("per_page")
    var perPage:String,
    @SerializedName("total")
    var total:String,
    @SerializedName("total_pages")
    var totalPages:String,
    @SerializedName("data")
    var data:String
)