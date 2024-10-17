package com.example.firstt

// Directivo.kt
class Directivo(
    nombre: String,
    edad: Int,
    sueldoBruto: Double,
    val categoria: String,
    val subordinados: MutableList<Empleado> = mutableListOf()
) : Empleado(nombre, edad, sueldoBruto) {

    fun agregarSubordinado(empleado: Empleado) {
        subordinados.add(empleado)
    }

    // Agregamos el modificador 'override' para sobrescribir la función de la clase Empleado
    override fun mostrarDatos() {
        println("Directivo: $nombre, Edad: $edad, Sueldo Bruto: $sueldoBruto, Categoría: $categoria")
        println("Subordinados:")
        subordinados.forEach { it.mostrarDatos() }
    }
}

