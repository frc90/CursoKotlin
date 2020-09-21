package com.example.cursokotlin.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Post(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("userId") val userId: Int,
    @Expose @SerializedName("title") val title: String,
    @Expose @SerializedName("body") val body: String
)


/*
* class Post{
    @SerializedName("id")
    val id: Int = 0
    @SerializedName("userId")
    val userId: Int = 0
    @SerializedName("title")
    val title: String = ""
    @SerializedName("body")
    val body: String = ""
}
* */