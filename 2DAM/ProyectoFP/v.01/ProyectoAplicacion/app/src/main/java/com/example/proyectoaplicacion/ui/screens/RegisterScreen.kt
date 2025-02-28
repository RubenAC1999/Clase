package com.example.proyectoaplicacion.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectoaplicacion.ui.theme.ProyectoAplicacionTheme

class RegisterScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoAplicacionTheme {
                val navController = rememberNavController()
                RegisterScreenContent(navController)
            }
        }
    }
}

@Composable
fun RegisterScreenContent(navController: NavController) {
    val colorFondo = Color(0xFF121212)
    val morado = Color(0xFF5F5AA2)

    var selectedDate by remember { mutableStateOf("") } // Estado para la fecha seleccionada

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(30.dp),
                text = "Registro",
                fontSize = 24.sp,
                color = morado
            )
            HorizontalDivider(
                modifier = Modifier.width(200.dp),
                color = morado,
                thickness = 1.dp,
            )
            alignedRegistrationRows(date = selectedDate, onDateChange = { selectedDate = it })
            buttonRegistrationRow(navController)
        }
    }
}

@Composable
fun buttonRegistrationRow(navController: NavController) {
    val morado = Color(0xFF5F5AA2)

    Column(
        modifier = Modifier.padding(13.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
               navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = morado
            ),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(
                text = "Atrás",
                color = Color.White
            )
        }
    }
}

@Composable
fun alignedRegistrationRows(date: String, onDateChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(13.dp)) {
        RegistrationRow("Usuario: ", "", onTextChange = {})
        RegistrationRow("Correo electrónico: ", "", onTextChange = {})
        RegistrationRow("Contraseña: ", "", onTextChange = {})
        RegistrationRow("Repita la contraseña: ", "", onTextChange = {})
    }
}

@Composable
fun RegistrationRow(label: String, text: String, onTextChange: (String) -> Unit) {
    Row(
        modifier = Modifier.padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            color = Color.White,
            modifier = Modifier.width(150.dp)
        )

        TextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier
                .weight(1f)
                .height(56.dp)
                .padding(3.dp),
            readOnly = true,
        )
    }
}

/* Pantalla de registro de prueba
TODO: Refactorizar con mutableState
 */
@Composable
fun registerScreenDemo(navController: NavController) {
    val nombre = remember { mutableStateOf("") }
    val correo = remember { mutableStateOf("") }
    val infoAdicional = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text()
    }
}