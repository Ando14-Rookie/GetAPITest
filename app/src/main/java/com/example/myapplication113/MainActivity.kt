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
    private val baseURL = "https://reqres.in/"

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

        myAPI.getData(2).enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse?>, response: Response<UserResponse>?) {
                val responseBody = response?.body()!!

                // Check null or not
                if (responseBody == null){
                    println("null has been found")
                }
                else{
                    println("All is okay")
                }

                responseBody?.data?.forEach { user ->
                    Log.i("check-done","onResponse to ${user}") }
            }

            override fun onFailure(call: Call<UserResponse>?, t: Throwable) {
                Log.i("check-done","Failure to ${t.message}")
            }
        })
    }
}


