package com.example.realhome.presentation.screens.homeScreen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun homeScreen(homeViewModel: HomeViewModel = hiltViewModel()){

    val Allproperties = homeViewModel.getAllProperty.collectAsLazyPagingItems()
Scaffold(
    topBar = {
        homeTopBar(onSearchClicked = {})

    }


) {

}


}