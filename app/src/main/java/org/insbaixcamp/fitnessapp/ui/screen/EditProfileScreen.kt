package org.insbaixcamp.fitnessapp.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.fitnessapp.R


@Composable
fun EditProfileScreen(
    nom: String,
    email: String,
    dataNaixament: String,
    generes: String,
    onEditar: () -> Unit,
    pes: Int,
    altura: Int
) {

    Column(){
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            Text(
                "Editar Perfil",
                modifier = Modifier.padding(16.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Button(onClick = onEditar) {
                Text("Cancelar")
            }
        }
        Row(

        ){
            Column() {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Foto de perfil",
                    modifier = Modifier.size(100.dp).padding(bottom = 8.dp) .clip(RoundedCornerShape(16.dp))
                )
            }
            Column {
                Button(
                    onClick = {}
                ) {
                    Icon(
                        painter = painterResource(android.R.drawable.btn_star),
                        contentDescription = "Editar perfil",
                        modifier = Modifier.size(20.dp)
                    )
                    Text("Canviar foto")
                }

                Button(
                    onClick = {}
                ) {

                    Icon(
                        painter = painterResource(android.R.drawable.btn_star),
                        contentDescription = "Editar perfil",
                        modifier = Modifier.size(20.dp)
                    )

                    Text("Eliminar foto")
                }
            }
        }








    }


}

