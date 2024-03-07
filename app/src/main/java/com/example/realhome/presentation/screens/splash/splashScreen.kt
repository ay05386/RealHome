package com.example.realhome.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.realhome.R
import com.example.realhome.ui.theme.Purple40
import com.example.realhome.ui.theme.Purple80

@Composable
fun SplashScreen(navController: NavHostController){
Splash()
}



@Composable
fun Splash(){
    Box(modifier = Modifier
        .background(Brush.verticalGradient(listOf(Purple80, Purple40)))
        .fillMaxSize(), contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.home_1_svgrepo_com), contentDescription = stringResource(
            R.string.app_logo
        )
        )
    }
}


@Preview
@Composable
fun splashprev() {
Splash()
}