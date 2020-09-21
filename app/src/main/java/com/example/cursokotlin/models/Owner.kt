package com.example.cursokotlin.models

class Owner (username: String){

    companion object{
        private const val DEFAULT_NAME = "No Name"
    }

    // inicializar variables
    var username: String = username
    var displayName:String = DEFAULT_NAME
        get() = field
        set(value) {field = value}

    init {
        // inicializamos las variables
    }

    constructor(username: String, displayName: String) : this(username) {
        // Inicializamos varibles
        this.displayName = displayName
    }
}