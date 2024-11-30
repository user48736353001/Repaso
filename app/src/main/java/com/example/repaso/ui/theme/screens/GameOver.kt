package com.example.repaso.ui.theme.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.repaso.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameOver (navController:NavHostController){
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
    )
    {
        body(

                modifier = Modifier.padding(it),
                navController
            )

    }
}
@Composable
fun body(modifier: Modifier = Modifier, navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { navController.navigate(route = AppScreens.Game.route) }

        ) {

            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "volver",
            )
            Text(text = "Reiniciar")
        }
    }
}