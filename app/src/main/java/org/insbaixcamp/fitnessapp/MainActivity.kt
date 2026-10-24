package org.insbaixcamp.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.insbaixcamp.fitnessapp.ui.screen.ProfileScreen
import org.insbaixcamp.fitnessapp.ui.screen.EditProfileScreen
import org.insbaixcamp.fitnessapp.ui.theme.FitnessAppTheme
import java.util.Date

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
fun FitnessApp(){
    var nom:String by remember { mutableStateOf("Laia Soler") }
    var email:String by remember { mutableStateOf("laia.soler@exemple.com") }
    var dataNaixament: String by remember { mutableStateOf("15/10/1999") }
    var genre: String by remember { mutableStateOf("Dona") }
    var editant: Boolean by remember { mutableStateOf(true) }
    var pes: Int by remember { mutableIntStateOf(60)  }
    var altura: Int by remember { mutableIntStateOf(165)  }



    if(editant){
        EditProfileScreen(nom, email, dataNaixament, genre, onEditar = {editant=true}, pes, altura)
    } else {
        ProfileScreen(nom, email, dataNaixament, genre, onEditar = {editant=true}, pes, altura)
    }

}



@Preview(showBackground = true)
@Composable
fun FitnessAppPreview() {
    FitnessAppTheme {
        FitnessApp()
    }
}