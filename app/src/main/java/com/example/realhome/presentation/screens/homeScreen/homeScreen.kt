package com.example.realhome.presentation.screens.homeScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.realhome.presentation.components.ratingWidget

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun homeScreen(homeViewModel: HomeViewModel = hiltViewModel()){

    val Allproperties = homeViewModel.getAllProperty.collectAsLazyPagingItems()
Scaffold(
    topBar = {
        homeTopBar(onSearchClicked = {})

    }


) {
ratingWidget(modifier = Modifier.padding(all = 5.dp), rating =4.1 )
}


}