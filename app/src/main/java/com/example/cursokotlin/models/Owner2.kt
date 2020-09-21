package com.example.cursokotlin.models

data class Owner2 (var username:String = "", var displaName:String = DEFAULT_NAME){

    companion object{
        private const val DEFAULT_NAME = "No Name"
    }
}