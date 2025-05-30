package com.example.retrofitapi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication113.APIAdapter
import com.example.myapplication113.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    // view binding for the activity
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val baseURL = "https://reqres.in/"

    // create reference to the adapter and the list
    // in the list pass the model of Language
    private lateinit var myAdapter: RecyclerView.Adapter<*>
    private lateinit var layoutManager1:RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initialize layout manager first
        layoutManager1 = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager1

        //Show all data in LogCat & show adapter
        getAllData()
    }
    fun getAllData(){
        val myAPI = Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ReqresAPI::class.java)

        myAPI.getData(2).enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>?) {
                val responseBody = response?.body()!!

                // Check null or not
                println("All is okay")
                if (response.isSuccessful) {

                    //Apply the recyclerView when response is Successful
                    binding.recyclerView.apply{
                        //Send required argument to adapter
                        myAdapter = APIAdapter(responseBody.data)
                        myAdapter.notifyDataSetChanged()
                        //set the adapter
                        adapter = myAdapter
                    }
                    //Send message in Logcat
                    responseBody.data.forEach { user ->
                        Log.i("check-done", "onResponse to ${user}")
                    }
                    //Debug
                    Log.d("Check debug", "My response: $response")
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("error","Failure to ${t.message}")
            }
        })
    }
}


