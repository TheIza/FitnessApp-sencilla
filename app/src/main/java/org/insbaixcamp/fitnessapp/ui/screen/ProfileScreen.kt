
package org.insbaixcamp.fitnessapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.fitnessapp.R
import java.util.Calendar

@Composable
fun ProfileScreen(
    nom: String,
    email: String,
    dataNaixament: String,
    generes: String,
    onEditar: () -> Unit,
    pes: Int,
    altura: Int,
    objectiu: String
) {

    val anys = try {
        Calendar.getInstance().get(Calendar.YEAR) -
                dataNaixament.split("/")[2].toInt()
    } catch (e: Exception) {
        0
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {

        // Capçalera
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "El meu perfil",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            IconButton(onClick = onEditar) {
                Icon(
                    painter = painterResource(android.R.drawable.ic_menu_edit),
                    contentDescription = "Editar perfil",
                    modifier = Modifier.size(22.dp)
                )
            }
        }

        // Foto i informació de l'usuari
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp, bottom = 22.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(85.dp)
                    .clip(RoundedCornerShape(50.dp))
            )

            Text(
                text = nom,
                modifier = Modifier.padding(top = 12.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = email,
                modifier = Modifier.padding(top = 4.dp),
                fontSize = 14.sp
            )
        }

        HorizontalDivider()

        // Dades personals
        Text(
            text = "Les meves dades",
            modifier = Modifier.padding(top = 22.dp, bottom = 12.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            DadaPerfil(
                etiqueta = "Alçada",
                valor = "$altura cm",
                modifier = Modifier.weight(1f)
            )

            DadaPerfil(
                etiqueta = "Pes",
                valor = "$pes kg",
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            DadaPerfil(
                etiqueta = "Edat",
                valor = "$anys anys",
                modifier = Modifier.weight(1f)
            )

            DadaPerfil(
                etiqueta = "Gènere",
                valor = generes,
                modifier = Modifier.weight(1f)
            )
        }

        // Objectiu
        Text(
            text = "El meu objectiu",
            modifier = Modifier.padding(top = 24.dp, bottom = 12.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = objectiu,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun DadaPerfil(
    etiqueta: String,
    valor: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 18.dp, horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = etiqueta,
                fontSize = 15.sp
            )

            Text(
                text = valor,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        }
    }
}
