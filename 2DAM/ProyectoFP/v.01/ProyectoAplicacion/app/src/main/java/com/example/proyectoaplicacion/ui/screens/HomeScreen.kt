package com.example.proyectoaplicacion.ui.screens

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectoaplicacion.ui.theme.ProyectoAplicacionTheme

class HomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoAplicacionTheme {
                val navController = rememberNavController()
                HomeScreenContent(navController)
            }
        }
    }
}

@Composable
fun HomeScreenContent(navController: NavController) {
    val colorFondo = Color(0xFF121212)
    val morado = Color(0xFF5F5AA2)
    val context = LocalContext.current
Box(
    modifier = Modifier
        .fillMaxSize()
        .background(colorFondo),
    contentAlignment = Alignment.Center
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Página principal",
            fontSize = 18.sp,
            color = morado,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate("AccountScreen")
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = morado
            )
        ) {
            Text(
                text = "Mi perfil",
                color = Color.White
            )
        }

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                val builder: AlertDialog.Builder = AlertDialog.Builder(context)
                builder
                    .setMessage("Seguro que desea salir?")
                    .setTitle("Cerrar sesión")
                    .setPositiveButton("Sí") { dialog, which ->
                        navController.navigate("LoginScreen")
                    }
                    .setNegativeButton("No") {dialog, which ->
                    }

                val exitDialog: AlertDialog = builder.create()
                exitDialog.show()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = morado
            )
        ) {
            Text(
                text = "Cerrar sesión",
                color = Color.White
            )
        }

    }

}
}