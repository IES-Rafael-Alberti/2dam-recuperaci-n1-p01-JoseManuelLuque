package com.jluqgon214.saludoycontadoresrecuperacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Funcion Saludar
 * Es la funcion principal y unica de la practica
 *
 * [showDialog]: Parametro usado para mostrar o dejar de mostrar la ventana de Dialogo
 * [buttonText]: Variable que controla el botno del texto
 * [name]: nombre del usuario que varia en el Dialogo
 * [acceptCounter]: Contador del boton aceptar
 * [canceltCounter]: Contador del boton cancelar
 *
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Saludar() {
    var showDialog by rememberSaveable {
        mutableStateOf(false)
    }
    var buttonText by rememberSaveable {
        mutableStateOf("Saludar")
    }
    var name by rememberSaveable {
        mutableStateOf("")
    }
    var acceptCounter by rememberSaveable {
        mutableStateOf(0)
    }
    var cancelCounter by rememberSaveable {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (name != ""){
            Text(text = "Hola, ${name}")
        }
        if (showDialog == true) {
            AlertDialog(
                onDismissRequest = {showDialog = false},
                modifier = Modifier.fillMaxSize().padding(top = 15.dp, bottom = 20.dp)) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Configuración", fontSize = 20.sp,
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth(),)

                    Spacer(modifier = Modifier.size(20.dp))

                    TextField(value = name, onValueChange = { name = it })

                    Spacer(modifier = Modifier.size(20.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(onClick = {
                            showDialog = false
                            acceptCounter += 1
                            buttonText = "A${acceptCounter} C${cancelCounter}"
                        }) {
                            Text(text = "Aceptar")
                        }
                        Button(onClick = { name = "" }){
                            Text(text = "Limpiar")
                        }
                        Button(onClick = {
                            showDialog = false
                            cancelCounter += 1
                            buttonText = "A${acceptCounter} C${cancelCounter}"
                        }) {
                            Text(text = "Cancelar")
                        }
                    }
                }
            }
        }
        Button(onClick = { showDialog = true }) {
            Text(text = buttonText)
        }
    }
}