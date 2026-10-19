package org.insbaixcamp.fitnessapp.ui.screen

import android.R.attr.text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


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








    }


}