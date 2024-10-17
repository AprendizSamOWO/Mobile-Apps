package com.example.firstt

// Cliente.kt
class Cliente(
    nombre: String,
    edad: Int,
    val telefono: String
) : Persona(nombre, edad) {
    fun mostrarDatos() {
        println("Cliente: $nombre, Edad: $edad, Teléfono: $telefono")
    }
}
