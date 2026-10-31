
package org.insbaixcamp.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import org.insbaixcamp.fitnessapp.ui.screen.ProfileScreen
import org.insbaixcamp.fitnessapp.ui.screen.EditProfileScreen
import org.insbaixcamp.fitnessapp.ui.theme.FitnessAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            FitnessAppTheme {
                FitnessApp()
            }
        }
    }
}

@Composable
fun FitnessApp() {

    // Datos originales del perfil
    var nom by remember { mutableStateOf("Laia Soler") }
    var email by remember { mutableStateOf("laia.soler@exemple.com") }
    var dataNaixament by remember { mutableStateOf("15/10/1999") }
    var genre by remember { mutableStateOf("Dona") }
    var pes by remember { mutableIntStateOf(0) }
    var altura by remember { mutableIntStateOf(0) }
    var objectiu by remember { mutableStateOf("Mantenir pes") }

    // Control de pantallas
    var editant by remember { mutableStateOf(false) }

    // Datos temporales para editar
    var nomEdit by remember { mutableStateOf(nom) }
    var emailEdit by remember { mutableStateOf(email) }
    var dataNaixamentEdit by remember { mutableStateOf(dataNaixament) }
    var genreEdit by remember { mutableStateOf(genre) }
    var pesEdit by remember { mutableStateOf(pes.toString()) }
    var alturaEdit by remember { mutableStateOf(altura.toString()) }
    var objectiuEdit by remember { mutableStateOf(objectiu) }

    if (editant) {

        EditProfileScreen( nom = nomEdit, onNomChange = { nomEdit = it }, email = emailEdit, onEmailChange = { emailEdit = it }, dataNaixament = dataNaixamentEdit, onNaixamentChange = { dataNaixamentEdit = it }, genere = genreEdit, onGenreChange = { genreEdit = it }, onEditar = { editant = false }, pes = pesEdit.toIntOrNull() ?: 0, onPesChange = { pesEdit = it }, altura = alturaEdit.toIntOrNull() ?: 0, onAlturaChange = { alturaEdit = it }, objectiu = objectiuEdit, onObjectiuChange = { objectiuEdit = it },
            //guardar
            onGuardar = {
                nom = nomEdit
                email = emailEdit
                dataNaixament = dataNaixamentEdit
                genre = genreEdit
                pes = pesEdit.toIntOrNull() ?: pes
                altura = alturaEdit.toIntOrNull() ?: altura
                objectiu = objectiuEdit

                editant = false
            },

            // Cancelar
            onCancelar = {
                editant = false
            }
        )

    } else {

        ProfileScreen(  nom = nom, email = email, dataNaixament = dataNaixament, generes = genre,

            onEditar = {
                // guardar los datos originales a los temporales
                nomEdit = nom
                emailEdit = email
                dataNaixamentEdit = dataNaixament
                genreEdit = genre
                pesEdit = pes.toString()
                alturaEdit = altura.toString()
                objectiuEdit = objectiu

                editant = true
            }, pes = pes, altura = altura, objectiu = objectiu
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FitnessAppPreview() {
    FitnessAppTheme {
        FitnessApp()
    }
}
