package com.example.proyectoaplicacion.ui.screens

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectoaplicacion.ui.theme.ProyectoAplicacionTheme

class LoginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoAplicacionTheme{
                val navController = rememberNavController()
                LoginScreenContent(navController)
            }
        }
    }
}

@Composable
fun LoginScreenContent(navController: NavController) {
    val colorFondo = Color(0xFF121212)
    val morado = Color(0xFF5F5AA2)
    val context = LocalContext.current

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
                    .padding(7.dp)
                    .clickable {
                        navController.navigate("RegisterScreen")  // Ahora debes poder navegar a RegisterScreen
                    },
                text = "No tienes cuenta? Regístrate aquí.",
                fontSize = 14.sp,
                color = morado
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("HomeScreen")
                    Toast.makeText(context, "Sesión iniciada", Toast.LENGTH_LONG).show()

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = morado
                )
            ) {
                Text(
                    text = "Entrar",
                    color = Color.White
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
    Column(modifier = Modifier.padding(13.dp)) {
        row("Usuario:       ")
        row("Contraseña: ")
    }
}