package com.example.proyectoaplicacion.ui


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoaplicacion.ui.screens.AccountScreenContent
import com.example.proyectoaplicacion.ui.screens.HomeScreenContent
import com.example.proyectoaplicacion.ui.screens.LoginScreenContent
import com.example.proyectoaplicacion.ui.screens.RegisterScreenContent
import com.example.proyectoaplicacion.ui.theme.ProyectoAplicacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoAplicacionTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "LoginScreen") {
                    composable("LoginScreen") { LoginScreenContent(navController) }
                    composable("RegisterScreen") { RegisterScreenContent(navController) }
                    composable("HomeScreen") {HomeScreenContent(navController) }
                    composable("AccountScreen") { AccountScreenContent(navController) }
                }
            }
        }
    }
}

@Composable
fun showExitConfirmationDialog(onConfirmExit: () -> Unit) {
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Cerrar sesión") },
            text = { Text(text = "¿Deseas cerrar la sesión?") },
            confirmButton = {
                Button(
                    onClick = {

                        onConfirmExit()
                        showDialog = false
                    }
                ) {
                    Text("Sí")
                }
            },
            dismissButton = {
                Button(
                    onClick = { showDialog = false }
                ) {
                    Text("No")
                }
            }
        )
    }
    Button(
        onClick = { showDialog = true },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF5F5AA2) // Morado
        ),
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Text(
            text = "Salir",
            color = Color.White
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoAplicacionTheme {

    }
}
