
package org.insbaixcamp.fitnessapp.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.fitnessapp.R
import org.insbaixcamp.fitnessapp.ui.component.MenuDesplegable


@Composable
fun EditProfileScreen(
    nom: String,
    email: String,
    dataNaixament: String,
    genere: String,
    onEditar: () -> Unit,
    pes: Int,
    altura: Int

) {
    var objectiu by rememberSaveable { mutableStateOf("")}
    var nivell by rememberSaveable { mutableStateOf("")}

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
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Foto de perfil",
                    modifier = Modifier.size(100.dp).clip(RoundedCornerShape(16.dp)).padding(8.dp).padding(start = 8.dp)
                )
            }
            Column {
                Button(
                    onClick = {},
                    modifier = Modifier.width(200.dp)
                ) {
                    Icon(

                        painter = painterResource(android.R.drawable.ic_menu_camera),
                        contentDescription = "Editar perfil",
                        modifier = Modifier.size(30.dp).padding(end = 8.dp)
                    )
                    Text("Canviar foto")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.width(200.dp)
                ) {
                    Icon(

                        painter = painterResource(android.R.drawable.ic_menu_delete),
                        contentDescription = "Editar perfil",
                        modifier = Modifier.size(30.dp).padding(end = 8.dp)
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


        Column() {
            OutlinedTextField(
                state = rememberTextFieldState("Nom Cognoms"),
                label = { Text("Nom complert") },
                modifier = Modifier.padding(8.dp)
            )
            OutlinedTextField(
                state = rememberTextFieldState("exemple@gmail.com "),
                label = { Text("Correu electrònic") },
                modifier = Modifier.padding(8.dp)
            )

            // datapicker de calendario

            MenuDesplegable(
                label = "Objectiu",
                opcions = listOf(
                    "Dona",
                    "Home",
                    "Preferixo no dir-ho"
                ),
                valorSeleccionat = objectiu,
                onValorSeleccionat = { objectiu = it },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            )



            Text(
                "Dades FIsiques",
                modifier = Modifier.padding(16.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Row(){

            }
        }




    }


}
