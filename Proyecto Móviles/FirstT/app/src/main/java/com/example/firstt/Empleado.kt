package com.example.firstt

// Empleado.kt
open class Empleado(
    nombre: String,
    edad: Int,
    val sueldoBruto: Double
) : Persona(nombre, edad) {

    // Marca la función como 'open' para permitir que sea sobrescrita
    open fun mostrarDatos() {
        println("Empleado: $nombre, Edad: $edad, Sueldo Bruto: $sueldoBruto")
    }
}
