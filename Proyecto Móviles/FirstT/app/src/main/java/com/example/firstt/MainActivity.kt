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
    val empleado1 = Empleado("Kesote", 30, 1500.0)
    val empleado2 = Empleado("Fubukis", 28, 1400.0)
    val directivo = Directivo("Gatogordo", 45, 3000.0, "Gerente")
    directivo.agregarSubordinado(empleado1)
    directivo.agregarSubordinado(empleado2)

    val cliente1 = Cliente("Zamudioi", 35, "999888777")
    val cliente2 = Cliente("6pingaman9", 40, "999777666")

    val empresa = Empresa("GRUPO69FISIDICKSTRAS")

    // PANTALLA

    empresa.agregarEmpleado(directivo)
    empresa.agregarEmpleado(empleado1)
    empresa.agregarCliente(cliente1)
    empresa.agregarCliente(cliente2)

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
