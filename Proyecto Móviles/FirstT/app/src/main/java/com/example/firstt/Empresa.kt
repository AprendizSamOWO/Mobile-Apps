package com.example.firstt

// Empresa.kt
class Empresa(
    val nombre: String,
    val empleados: MutableList<Empleado> = mutableListOf(),
    val clientes: MutableList<Cliente> = mutableListOf()
) {
    fun agregarEmpleado(empleado: Empleado) {
        empleados.add(empleado)
    }

    fun agregarCliente(cliente: Cliente) {
        clientes.add(cliente)
    }

    fun mostrarDatos() {
        println("Empresa: $nombre")
        println("Empleados:")
        empleados.forEach { it.mostrarDatos() }
        println("Clientes:")
        clientes.forEach { it.mostrarDatos() }
    }
}
