package com.example.retrofitapi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.example.myapplication113.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private val baseURL = "https://reqres.in/api/users?page=2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //Show all data in LogCat
        getAllData()
    }
    fun getAllData(){
        val myAPI = Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ReqresAPI::class.java)

        myAPI.getData().enqueue(object : Callback<List<DataAPI>>{
            override fun onResponse(call: Call<List<DataAPI>?>, response: Response<List<DataAPI>>?) {
                val responseBody = response?.body()!!
                for (mes in responseBody){
                    Log.i("check-done","onResponse to ${mes.avatar}") }
            }

            override fun onFailure(call: Call<List<DataAPI>>?, t: Throwable) {
                Log.i("check-done","Failure to ${t.message}")
            }
        })
    }
}


