package com.example.proyectoaplicacion


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class IntentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
                        text = "Intent activity",
                        fontSize = 24.sp,
                        color = morado
                    )
                    HorizontalDivider(
                        modifier = Modifier.width(200.dp),
                        color = morado,
                        thickness = 1.dp,
                    )
                    Button(
                        onClick = {finish()  },
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
        }
    }
}


