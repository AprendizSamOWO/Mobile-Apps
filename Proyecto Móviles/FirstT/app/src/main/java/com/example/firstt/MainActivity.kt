package com.example.firstt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.firstt.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                EmpresaScreen()
            }
        }
    }
}

@Composable
fun EmpresaScreen() {
    // Datos de ejemplo
    val empleado1 = Empleado("Oscar", 30, 2500.0)
    val empleado2 = Empleado("Pedro", 28, 2400.0)
    val directivo = Directivo("Gelber Christian", 45, 5000.0, "Gerente")
    directivo.agregarSubordinado(empleado1)
    directivo.agregarSubordinado(empleado2)

    val cliente1 = Cliente("Zamudio", 22, "991655590")
    val cliente2 = Cliente("Ivan", 23, "956747626")
    val cliente3 = Cliente("Brayan", 24, "995756476")
    val cliente4 = Cliente("Stefano", 25, "966767663")
    val cliente5 = Cliente("Wilson", 26, "969634626")

    val empresa = Empresa("FISI_GRUPO07_DSM")

    // PANTALLA

    empresa.agregarEmpleado(directivo)
    empresa.agregarEmpleado(empleado1)
    empresa.agregarEmpleado(empleado2)
    empresa.agregarCliente(cliente1)
    empresa.agregarCliente(cliente2)
    empresa.agregarCliente(cliente3)
    empresa.agregarCliente(cliente4)
    empresa.agregarCliente(cliente5)

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Empresa: ${empresa.nombre}", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Empleados", style = MaterialTheme.typography.h6)
        empresa.empleados.forEach { empleado ->
            EmpleadoCard(empleado)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Clientes", style = MaterialTheme.typography.h6)
        empresa.clientes.forEach { cliente ->
            ClienteCard(cliente)
        }
    }
}

@Composable
fun EmpleadoCard(empleado: Empleado) {
    Card(modifier = Modifier.fillMaxWidth(), elevation = 4.dp) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = "Nombre: ${empleado.nombre}")
            Text(text = "Edad: ${empleado.edad}")
            Text(text = "Sueldo Bruto: ${empleado.sueldoBruto}")
            if (empleado is Directivo) {
                Text(text = "Categoría: ${empleado.categoria}")
            }
        }
    }
}

@Composable
fun ClienteCard(cliente: Cliente) {
    Card(modifier = Modifier.fillMaxWidth(), elevation = 4.dp) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = "Nombre: ${cliente.nombre}")
            Text(text = "Edad: ${cliente.edad}")
            Text(text = "Teléfono: ${cliente.telefono}")
        }
    }
}
