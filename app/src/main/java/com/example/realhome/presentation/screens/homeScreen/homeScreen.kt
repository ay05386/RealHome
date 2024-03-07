package com.example.realhome.presentation.screens.homeScreen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun homeScreen(){
Scaffold(
    topBar = {
        homeTopBar(onSearchClicked = {})

    }


) {

}


}