package com.example.proyectoaplicacion

import android.hardware.Sensor
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.Border
import com.example.proyectoaplicacion.ui.theme.ProyectoAplicacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoAplicacionTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "second_screen") {
                    composable("second_screen") { secondScreen(navController) }
                }
            }
        }
    }
}


@Composable
fun firstScreen(navController: NavController) {
    val colorFondo = Color(0xFF121212)
    val morado = Color(0xFF5F5AA2)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            borderedText()
            Text(
                modifier = Modifier.padding(10.dp),
                text = "Inicio de sesión",
                fontSize = 18.sp,
                color = morado,
                fontWeight = FontWeight.Bold
            )
            HorizontalDivider(
                modifier = Modifier.width(200.dp),
                color = morado,
                thickness = 1.dp,
            )
            alignedLoginRows()
            Text(
                modifier = Modifier
                    .padding(7.dp),
                text = "No tienes cuenta? Regístrate aquí.",
                fontSize = 14.sp,
                color = morado
            )

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = morado
                )
            ) {
                Text(
                    text = "Entrar"
                )
            }
        }

    }
}

@Composable
fun header(text: String) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}

@Composable
fun borderedText() {
    val morado = Color(0xFF5F5AA2)
    Box(
        modifier = Modifier
            .padding(8.dp)
            .border(2.dp, morado)
            .padding(8.dp)
    ) {
        header("GAME TRACKER")
    }
}


@Composable
fun row(text : String ) {
    val morado = Color(0xFF5F5AA2)
    var textFieldValue = ""
    Row(
        modifier = Modifier
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            color = morado,
            modifier = Modifier.padding(end = 8.dp)
        )
        TextField(
            value = textFieldValue,
            onValueChange = { newText -> textFieldValue = newText },
            modifier = Modifier
                .height(15.dp)
                .width(180.dp),
            textStyle = TextStyle(
                fontSize = 14.sp
            ),
        )
    }
}


@Composable
fun alignedLoginRows() {
    Column(modifier = Modifier.padding(16.dp)) {
        row("Usuario:   ")
        row("Contraseña: ")
    }
}

@Composable
fun RegistrationRow(label: String) {
    var text by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Etiqueta
        Text(
            text = label,
            color = Color.White,
            modifier = Modifier.width(150.dp) // Ancho fijo para las etiquetas
        )

        // TextField
        TextField(
            value = text,
            onValueChange = { newText -> text = newText },
            modifier = Modifier
                .weight(1f)
                .height(30.dp)
                .padding(3.dp)
        )
    }
}

@Composable
fun alignedRegistrationRows() {
    Column(modifier = Modifier.padding(13.dp)) {
        RegistrationRow("Usuario: ")
        RegistrationRow("Correo electrónico:")
        RegistrationRow("Contraseña: ")
        RegistrationRow("Repita la contraseña:")
    }
}


@Composable
fun secondScreen(navController: NavController) {
    val colorFondo = Color(0xFF121212)
    val morado = Color(0xFF5F5AA2)
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
            alignedRegistrationRows()
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoAplicacionTheme {

    }
}
