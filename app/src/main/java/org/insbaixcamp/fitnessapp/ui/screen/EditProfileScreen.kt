
package org.insbaixcamp.fitnessapp.ui.screen


import android.media.Image
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.fitnessapp.R
import org.insbaixcamp.fitnessapp.ui.component.MenuDesplegable
import org.insbaixcamp.fitnessapp.ui.component.OutlinedDatePickerField


@Composable
fun EditProfileScreen(
    nom: String,
    onNomChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    dataNaixament: String,
    onNaixamentChange: (String) -> Unit,
    genere: String,
    onGenreChange: (String) -> Unit,
    onEditar: () -> Unit,
    pes: Int,
    onPesChange: (String) -> Unit,
    altura: Int,
    onAlturaChange: (String) -> Unit

) {
    var genereSelect by rememberSaveable { mutableStateOf("")}
    var objectiu by rememberSaveable { mutableStateOf("")}
    var img by rememberSaveable { mutableStateOf( R.drawable.ic_launcher_foreground)}
    var fotoSeleccionada by rememberSaveable { mutableStateOf<Uri?>(null) }

    val selectorImagen = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        if (uri != null) {
            fotoSeleccionada = uri
        }
    }
    Column() {
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = onEditar,
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(android.R.drawable.ic_menu_rotate),
                    contentDescription = "Editar perfil",
                    modifier = Modifier.size(20.dp)
                )
            }
            Text(
                "Editar Perfil",
                modifier = Modifier.padding(16.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )


        }
        Text(
            "Foto de perfil",
            modifier = Modifier.padding(8.dp).padding(start = 8.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {

            Column() {
                Image(
                    painter = painterResource(img),
                    contentDescription = "Foto de perfil",
                    modifier = Modifier.size(100.dp).clip(RoundedCornerShape(16.dp)).padding(8.dp).padding(start = 8.dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Button(
                    onClick = {
                        selectorImagen.launch("image/*")
                    },
                    modifier = Modifier
                        .width(220.dp)
                        .height(42.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE5F2EC),
                        contentColor = Color(0xFF348F70)
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 0.dp
                    )
                ) {
                    Icon(
                        painter = painterResource(android.R.drawable.ic_menu_camera),
                        contentDescription = "Canviar foto",
                        modifier = Modifier
                            .size(20.dp)
                            .padding(end = 4.dp)
                    )
                    Text("Canviar foto")
                }

                Button(
                    onClick = {
                        img = R.drawable.ic_launcher_foreground
                    },
                    modifier = Modifier
                        .width(220.dp)
                        .height(42.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFFCEBEC),
                        contentColor = Color(0xFFE53935)
                    ),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 0.dp
                    )
                ) {
                    Icon(
                        painter = painterResource(android.R.drawable.ic_menu_delete),
                        contentDescription = "Eliminar foto",
                        modifier = Modifier
                            .size(20.dp)
                            .padding(end = 4.dp)
                    )
                    Text("Eliminar foto")
                }
            }
        }

        Text(
            "Dades personals",
            modifier = Modifier.padding(8.dp).padding(start = 8.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )


        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            OutlinedTextField(
                value = nom,
                onValueChange = { nuevoTexto -> onNomChange(nuevoTexto) },
                label = { Text("Nom complert") },
                modifier = Modifier.padding(8.dp).fillMaxWidth()
            )
            OutlinedTextField(
                value = email,
                onValueChange = { nuevoEmail -> onEmailChange(nuevoEmail) },
                label = { Text("Correu electrònic") },
                modifier = Modifier.padding(8.dp).fillMaxWidth()
            )


            var birthDate by remember { mutableStateOf<Long?>(null) }

            OutlinedDatePickerField(
                label = "Data de naixement",
                selectedDateMillis = birthDate,
                onDateSelected = { millis ->
                    birthDate = millis

                    val formatter = java.text.SimpleDateFormat("dd/MM/yyyy", java.util.Locale.getDefault())
                    val fechaString = formatter.format(java.util.Date(millis))

                    onNaixamentChange(fechaString)
                },
                modifier = Modifier.padding(8.dp).fillMaxWidth()
            )



            MenuDesplegable(
                label = "Gènere",
                opcions = listOf(
                    "Dona",
                    "Home",
                    "Preferixo no dir-ho"
                ),
                valorSeleccionat = genere,
                onValorSeleccionat = { nouGenere ->
                    onGenreChange(nouGenere)
                },
                modifier = Modifier.padding(8.dp).fillMaxWidth()
            )



            Text(
                "Dades Fisiques",
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = altura.toString(),
                    onValueChange = { nuevaAltura -> onAlturaChange(nuevaAltura)  },
                    label = { Text("Altura (cm)") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                )

                OutlinedTextField(
                    value = pes.toString(),
                    onValueChange = { nuevoPeso -> onPesChange(nuevoPeso) },
                    label = { Text("Peso (kg)") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                )

                OutlinedTextField(
                    state = rememberTextFieldState("55"),
                    label = { Text("Objetivo (kg)") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                )
            }

            Text(
                "Objectiu principal",
                modifier = Modifier.padding(16.dp).fillMaxWidth(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                MenuDesplegable(
                    label = "Objectiu...",
                    opcions = listOf(
                        "Guanyar massa muscular",
                        "Perdre massa muscular",
                        "Mantenir pes"
                    ),
                    valorSeleccionat = objectiu,
                    onValorSeleccionat = { objectiu = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }


        }




    }


}
