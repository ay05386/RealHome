package com.example.realhome.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.example.realhome.presentation.screens.homeScreen.homeScreen
//import com.example.realhome.presentation.screens.homeScreen.homeScreen
import com.example.realhome.presentation.screens.splash.SplashScreen
import com.example.realhome.util.Constants.DETAILS_ARGUMENT_ID
@ExperimentalAnimationApi
@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun Setupnavgraph(navController: NavHostController){
NavHost(navController = navController, startDestination = Screen.Splash.route){
    composable(route = Screen.Splash.route){
     SplashScreen(navController = navController)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }
    composable(route = Screen.Home.route){
homeScreen(navController)
    }
    composable(route = Screen.Welcome.route){

    }
    composable(route = Screen.Details.route, arguments = listOf(navArgument(DETAILS_ARGUMENT_ID){
        type= NavType.IntType
    })){

    }
    composable(route = Screen.search.route){

    }
}
}