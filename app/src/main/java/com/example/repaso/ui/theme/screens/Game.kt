package com.example.repaso.ui.theme.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.repaso.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Game (navController:NavHostController){
    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                ),
                title ={Text ("Carta Alta")},
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "volver",
                        modifier = Modifier.clickable(){
                            navController.popBackStack()
                        }
                    )
                },
            )
        },
    ){
        bodyContent(
            modifier = Modifier.padding(it),
            navController,
        )
    }
}
@Composable
fun bodyContent( modifier: Modifier = Modifier,navController: NavHostController) {
    var currentStep by remember { mutableStateOf(1)}
    var result1 = 1
    var result2 = 1

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when(currentStep){
            1->{

                Row(horizontalArrangement = Arrangement.Center) {

                    Button(onClick = {
                        result1 = (1..13).random()
                        currentStep = 2
                    }
                    ) {
                        Text(text = "Area de juego de Jugador 1")
                    }
                    Text(text = "No ha robado aún")
                }
                Row(horizontalArrangement = Arrangement.Center) {
                    Button(onClick = {result2 = (1..13).random()
                    }
                    ) {
                        Text(text = "Area de juego de Jugador 2")
            }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "No ha robado aún")
                }
                }
            }
            2->{
                Row(horizontalArrangement = Arrangement.Center) {
                    Button(onClick = {

                    }
                    ) {
                        Text(text = "Area de juego de Jugador 1")
                    }
                        Text(text = "Su carta es $result1")
                    Row(horizontalArrangement = Arrangement.Center) {
                        Button(onClick = {result2 = (1..13).random()
                            currentStep= 3}
                        ) {
                            Text(text = "Area de juego de Jugador 2")
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "No ha robado aún")
                        }
                    }
                }
            }
            3->{Row(horizontalArrangement = Arrangement.Center) {
                Button(onClick = {

                }
                ) {
                    Text(text = "Area de juego de Jugador 1")
                }

                Text(text = "Su carta es $result1")
                Row(horizontalArrangement = Arrangement.Center) {
                    Button(onClick = {result2 = (1..13).random() }
                    ) {
                        Text(text = "Area de juego de Jugador 2")
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Su carta es $result2")
                        }
                    }
                }
            }
        }
        Button(
            onClick = { navController.navigate(route = AppScreens.GameOver.route)},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text(text = "Terminar partida")
        }
    }
}