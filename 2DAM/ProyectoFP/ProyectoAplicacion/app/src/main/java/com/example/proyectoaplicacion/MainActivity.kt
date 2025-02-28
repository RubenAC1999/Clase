package com.example.proyectoaplicacion


import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorManager
import android.net.Uri
import android.os.Build
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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoaplicacion.ui.theme.ProyectoAplicacionTheme
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import java.util.Calendar


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoAplicacionTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "signUpScreen") {
                    composable("signUpScreen") { signUpScreen(navController) }
                    composable("registerScreen") { registerScreen(navController) }
                    composable("myAccountScreen") { myAccountScreen(navController) }
                    composable("myLibraryScreen") { myLibraryScreen(navController) }
                    composable( "settingsScreen") { settingsScreen(navController) }
                    composable("deviceInformationScreen") { deviceInformationScreen(navController)}
                    composable("sensorInformationScreen") {sensorInformationScreen(navController)}
                    composable("intentScreen") {intentScreen(navController)}
                }
            }
        }
    }

}

@Composable
fun signUpScreen(navController: NavController) {
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
                    .clickable { navController.navigate("registerScreen") },
                text = "No tienes cuenta? Regístrate aquí.",
                fontSize = 14.sp,
                color = morado
            )

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                        navController.navigate("myAccountScreen")
                        Toast.makeText(context, "Sesión iniciada", Toast.LENGTH_LONG).show()

                },
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
    Column(modifier = Modifier.padding(13.dp)) {
        row("Usuario:       ")
        row("Contraseña: ")
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
            trailingIcon = {
                Icon(Icons.Default.DateRange, contentDescription = "Seleccionar fecha")
            }
        )
    }
}

@Composable
fun alignedRegistrationRows(date: String, onDateChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(13.dp)) {
        RegistrationRow("Usuario: ", "", onTextChange = {})
        RegistrationRow("Correo electrónico: ", "", onTextChange = {})
        RegistrationRow("Contraseña: ", "", onTextChange = {})
        RegistrationRow("Repita la contraseña: ", "", onTextChange = {})

        DatePickerField(date = date, onDateSelected = onDateChange)
    }
}



@Composable
fun buttonRegistrationRow(navController : NavController) {
    val morado = Color(0xFF5F5AA2)

    Column(
        modifier = Modifier.padding(13.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navController.navigate("signUpScreen") },
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
        Button(
            onClick = { navController.navigate("myAccountScreen") },
            colors = ButtonDefaults.buttonColors(
                containerColor = morado
            ),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(
                text = "Registrarse",
                color = Color.White
            )
        }
    }
}



@Composable
fun registerScreen(navController: NavController) {
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
fun DatePickerField(date: String, onDateSelected: (String) -> Unit) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val datePickerDialog = remember {
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${month + 1}/$year"
                onDateSelected(selectedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
    }

    TextField(
        value = date,
        onValueChange = { },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(3.dp)
            .clickable {
                datePickerDialog.show()
            },
        readOnly = true,
        trailingIcon = {
            Icon(Icons.Default.DateRange, contentDescription = "Seleccionar fecha")
        },
        label = { Text("Fecha de nacimiento") }
    )
}


@Composable
fun myAccountScreen(navController : NavController) {
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
                text = "Mi cuenta",
                fontSize = 24.sp,
                color = morado
            )
            HorizontalDivider(
                modifier = Modifier.width(200.dp),
                color = morado,
                thickness = 1.dp,
            )
            Button(
                onClick = { navController.navigate("settingsScreen") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = morado
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Ajustes",
                    color = Color.White
                )
            }
            Button(
                onClick = { navController.navigate("myLibraryScreen") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = morado
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Ver mi biblioteca",
                    color = Color.White
                )
            }
            Button(
                onClick = { navController.navigate("intentScreen")},
                colors = ButtonDefaults.buttonColors(
                    containerColor = morado
            ),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Ver intents",
                    color = Color.White
                )
            }
            Button(
                onClick = { navController.navigate("layoutsScreen")},
                colors = ButtonDefaults.buttonColors(
                    containerColor = morado
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Ver layouts",
                    color = Color.White
                )
            }
            showExitConfirmationDialog {
                navController.navigate("signUpScreen")
            }

        }
    }
}

@Composable
fun myLibraryScreen(navController : NavController) {
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
                text = "Biblioteca",
                fontSize = 24.sp,
                color = morado
            )
            HorizontalDivider(
                modifier = Modifier.width(200.dp),
                color = morado,
                thickness = 1.dp,
            )
            Button(
                onClick = { navController.navigate("settingsScreen") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = morado
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Ajustes",
                    color = Color.White
                )
            }
            Button(
                onClick = { navController.navigate("myAccountScreen") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = morado
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Mi Cuenta",
                    color = Color.White
                )
            }
            Button(
                onClick = { navController.navigate("myAccountScreen") },
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

@Composable
fun settingsScreen(navController : NavController) {
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
                text = "Ajustes",
                fontSize = 24.sp,
                color = morado
            )
            HorizontalDivider(
                modifier = Modifier.width(200.dp),
                color = morado,
                thickness = 1.dp,
            )
            Button(
                onClick = { navController.navigate("myLibraryScreen") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = morado
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Mi Biblioteca",
                    color = Color.White
                )
            }
            Button(
                onClick = { navController.navigate("deviceInformationScreen") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = morado
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Ver información del sistema",
                    color = Color.White
                )
            }
            Button(
                onClick = { navController.navigate("sensorInformationScreen") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = morado
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Ver información de los sensores",
                    color = Color.White
                )
            }
            Button(
                onClick = { navController.navigate("myAccountScreen") },
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

@Composable
fun deviceInformationScreen(navController : NavController) {
    val morado = Color(0xFF5F5AA2)
    val colorFondo = Color(0xFF121212)

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
                text = "Información del dispositivo",
                fontSize = 24.sp,
                color = morado
            )
            alignedInfoRows()
            Button(
                onClick = { navController.navigate("settingsScreen") },
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

@Composable
fun alignedInfoRows() {
    val fabricante = Build.MANUFACTURER
    val modelo = Build.MODEL
    val versionAndroid = Build.VERSION.RELEASE
    val apiLevel = Build.VERSION.SDK_INT
    val marca = Build.BRAND;

    Column(modifier = Modifier.padding(13.dp)) {
        Column(modifier = Modifier.padding(13.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Fabricante: " + fabricante,
                    color = Color.White
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Modelo: " + modelo,
                    color = Color.White
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Versión de Android: " + versionAndroid,
                    color = Color.White
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Versión de SDK: " + apiLevel.toString(),
                    color = Color.White
                )
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Marca: " + marca,
                    color = Color.White
                )
            }
        }

    }
}


@Composable
fun sensorInformationScreen(navController: NavController) {
    val morado = Color(0xFF5F5AA2)
    val colorFondo = Color(0xFF121212)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()), // Agrega scroll vertical
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(30.dp),
                text = "Información de los sensores",
                fontSize = 24.sp,
                color = morado
            )

            sensorInfo()

            Button(
                onClick = { navController.navigate("settingsScreen") },
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

@Composable
fun sensorInfo() {
    val morado = Color(0xFF5F5AA2)
    val context = LocalContext.current
    val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val accelerometerInfo = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER)
    val gyroscopeInfo = sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE)
    val magneticFieldInfo = sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD)
    val lightSensorInfo = sensorManager.getSensorList(Sensor.TYPE_LIGHT)

    Column(modifier = Modifier.padding(13.dp)) {
        Text(
            modifier = Modifier.padding(30.dp),
            text = "Información del acelerómetro",
            fontSize = 24.sp,
            color = morado
        )
        accelerometerInfo.forEach { sensor ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Sensor: ${sensor.name}, Tipo: ${sensor.stringType}",
                    color = Color.White
                )
            }
        }
        Text(
            modifier = Modifier.padding(30.dp),
            text = "Información del giroscopio",
            fontSize = 24.sp,
            color = morado
        )
        gyroscopeInfo.forEach { sensor ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Sensor: ${sensor.name}, Tipo: ${sensor.stringType}",
                    color = Color.White
                )
            }
        }
        Text(
            modifier = Modifier.padding(30.dp),
            text = "Información del campo magnético",
            fontSize = 24.sp,
            color = morado
        )
        magneticFieldInfo.forEach { sensor ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Sensor: ${sensor.name}, Tipo: ${sensor.stringType}",
                    color = Color.White
                )
            }
        }
        Text(
            modifier = Modifier.padding(30.dp),
            text = "Información del sensor de luz",
            fontSize = 24.sp,
            color = morado
        )
        lightSensorInfo.forEach { sensor ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Sensor: ${sensor.name}, Tipo: ${sensor.stringType}",
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun intentScreen(navController: NavController) {
    val context = LocalContext.current
    val intent = Intent(context, IntentActivity::class.java)
    var isServiceRunning by remember { mutableStateOf(false) }

    val morado = Color(0xFF5F5AA2)
    val verde = Color(0XFF42A15B)
    val colorFondo = Color(0xFF121212)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorFondo),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(30.dp),
                text = "Intents",
                fontSize = 24.sp,
                color = morado
            )
            Button(
                onClick = {
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = morado
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Intent Activity",
                    color = Color.White
                )
            }
            Button(
                onClick = {
                    val myServiceIntent = Intent(context, MyService::class.java)
                    if (isServiceRunning) {
                        context.stopService(myServiceIntent)
                        isServiceRunning = false

                    } else {
                        context.startService(myServiceIntent)
                        isServiceRunning = true
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isServiceRunning) verde else Color.Gray
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = if (isServiceRunning) "Finalizar servicio" else "Iniciar Servicio",
                    color = Color.White
                )
            }

            Button(
                onClick = {
                    val url = "https://store.steampowered.com/login/?redir=%3Fl%3Dspanish&redir_ssl=1&snr=1_4_4__global-header"
                    val webIntent = Intent(Intent.ACTION_VIEW).apply {
                        data = Uri.parse(url)
                    }
                    context.startActivity(webIntent)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = morado
                ),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = "Vincular cuenta de Steam", //Intent que abre otra página
                    color = Color.White
                )
            }

            Button(
                onClick = { navController.navigate("myAccountScreen") },
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
