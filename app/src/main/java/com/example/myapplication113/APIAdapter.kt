package com.example.myapplication113

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapi.DataAPI
import com.bumptech.glide.Glide
import com.example.myapplication113.databinding.CardDesignBinding
import com.example.retrofitapi.UserResponse


class APIAdapter(private val listAPI: List<DataAPI>): RecyclerView.Adapter<APIAdapter.ViewHolder>() {

    class ViewHolder(val itemBinding : CardDesignBinding): RecyclerView.ViewHolder(itemBinding.root){

        fun bind(property: DataAPI){
            val firstName = itemBinding.userFirstName
            val lastName = itemBinding.userLastName
            val imageView = itemBinding.imageView
            val email = itemBinding.userEmail
            val id = itemBinding.userID

            //Set the TextView based on the info from each DataAPI
            firstName.text = property.firstName
            lastName.text = property.lastName
            email.text = property.email
            id.text = property.id.toString()

            //To load the picture using Glide
            Glide.with(itemBinding.root.context).load(property.avatar)
                .centerCrop().into(imageView)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = CardDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listAPI.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listAPI[position])
    }
}