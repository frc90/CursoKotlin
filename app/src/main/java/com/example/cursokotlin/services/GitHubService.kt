package com.example.cursokotlin.services

import com.example.cursokotlin.models.Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    @GET("user/{user}/repos")
    fun listRepos(@Path("user")user: String?): Call<List<Repo>>
}