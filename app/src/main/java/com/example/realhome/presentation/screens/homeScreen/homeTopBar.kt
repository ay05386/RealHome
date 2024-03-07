package com.example.realhome.presentation.screens.homeScreen

import android.icu.text.CaseMap.Title
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.realhome.R
import com.example.realhome.ui.theme.topAppbarcontentcolor
import com.example.realhome.ui.theme.topappbarbackgroundcolor

@Composable
fun homeTopBar(onSearchClicked:() ->Unit){
TopAppBar(
    title = {
     Text(text = "Explore", color = MaterialTheme.colors.topAppbarcontentcolor)
    }, backgroundColor = MaterialTheme.colors.topappbarbackgroundcolor,
       actions = {
           IconButton(onClick = {onSearchClicked }) {
               Icon(imageVector = Icons.Default.Search, contentDescription = stringResource(R.string.search_icon))
           }
       }
)


}
@Composable
@Preview
fun hometopbarpreview(){
    homeTopBar {}
}
/*
TopAppBar(
title = {
    Text(text = "Explore", color = MaterialTheme.colors.topAppbarcontentcolor) }
) {

}*/