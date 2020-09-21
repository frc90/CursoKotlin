package com.example.cursokotlin.services

import com.example.cursokotlin.models.Post
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderService {
    @GET("posts")
    fun getPost(): Call<List<Post>>
}