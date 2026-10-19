
package org.insbaixcamp.fitnessapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.painter.Painter
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
    altura: Int
) {
    Column(
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically


        ) {
            Text(
                "Perfil",
                modifier = Modifier.padding(16.dp),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            IconButton(
                onClick = onEditar,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    painter = painterResource(android.R.drawable.ic_menu_edit),
                    contentDescription = "Editar perfil",
                    modifier = Modifier.size(20.dp)
                )
            }
        }


        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp) ,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "Foto de perfil",
                    modifier = Modifier.size(100.dp).padding(bottom = 8.dp) .clip(RoundedCornerShape(16.dp))
                )

                Text(
                    text = nom,
                    modifier = Modifier.padding(8.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    email,
                    modifier = Modifier.padding(4.dp),
                    fontSize = 12.sp
                )
            }

            Card() {
                Row(
                    modifier = Modifier.padding(16.dp).fillMaxWidth()

                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {


                        Image(
                            painter = painterResource(android.R.drawable.ic_menu_my_calendar),
                            contentDescription = "Foto edad",
                            modifier = Modifier.size(40.dp)

                        )



                        val anys: Int = Calendar.getInstance().get(Calendar.YEAR) -
                                dataNaixament.split("/")[2].toInt()


                        Text(
                            text = anys.toString(),
                            modifier = Modifier.padding(8.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Edat",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 24.sp
                        )


                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {

                        Image(
                            painter = painterResource(android.R.drawable.ic_menu_my_calendar),
                            contentDescription = "Foto edad",
                            modifier = Modifier.size(40.dp)

                        )

                        Text(
                            text = generes,
                            modifier = Modifier.padding(8.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Genere",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 24.sp
                        )
                    }

                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(android.R.drawable.ic_menu_my_calendar),
                            contentDescription = "Foto edad",
                            modifier = Modifier.size(40.dp)

                        )

                        Text(
                            text = "$altura cm",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Altura",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 24.sp
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            painter = painterResource(android.R.drawable.ic_menu_my_calendar),
                            contentDescription = "Foto edad",
                            modifier = Modifier.size(40.dp)

                        )

                        Text(
                            text = "$pes kg ",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Pes",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 24.sp
                        )

                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    "Objectius",
                    modifier = Modifier.padding(8.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Text("editar")
            }




            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),

            ) {
                Card(modifier = Modifier.weight(1f)
                ) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ){
                        Image(
                            painter = painterResource(android.R.drawable.ic_menu_my_calendar),
                            contentDescription = "Foto edad",
                            modifier = Modifier.size(40.dp).padding(top = 8.dp)

                        )

                        Text(
                            "Guanyar massa muscular",
                            modifier = Modifier.padding(8.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        )
                    }

                }

                Card(modifier = Modifier.weight(1f)) {

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {

                        Image(
                            painter = painterResource(android.R.drawable.ic_menu_my_calendar),
                            contentDescription = "Foto edad",
                            modifier = Modifier.size(40.dp).padding(top = 8.dp)

                        )

                        Text(
                            "Millorar la salut",
                            modifier = Modifier.padding(8.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        )
                    }
                }

                Card(modifier = Modifier.weight(1f)) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {
                        Image(
                            painter = painterResource(android.R.drawable.ic_menu_my_calendar),
                            contentDescription = "Foto edad",
                            modifier = Modifier.size(40.dp).padding(top = 8.dp)

                        )

                        Text(
                            "Mantenir el pes",
                            modifier = Modifier.padding(8.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    "Nivell d'activitat",
                    modifier = Modifier.padding(8.dp),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "editar"
                )
            }

            Card() {
                Column() {
                    Text(
                        "Moderat",
                        modifier = Modifier.padding(8.dp),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        "Entreno 3-4 vegades per setmana",
                        modifier = Modifier.padding(8.dp),
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}
