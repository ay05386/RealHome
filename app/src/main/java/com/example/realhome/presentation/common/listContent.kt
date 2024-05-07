package com.example.realhome.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Shapes
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.realhome.R
import com.example.realhome.domain.model.Property
import com.example.realhome.navigation.Screen
import com.example.realhome.util.Constants.BASE_URL

@Composable
fun listContent(property: LazyPagingItems<Property>,navHostController: NavHostController){

}
@ExperimentalCoilApi
@Composable
fun Propertyitem(property: Property,navHostController: NavHostController){
val painter = rememberAsyncImagePainter(model = "$BASE_URL${property.image}",
    placeholder = painterResource(
    id = R.drawable.ic_placeholder
),error = painterResource(
        id = R.drawable.ic_placeholder
    ))






    //if it didn't work replace it with the async one
Box (modifier = Modifier
    .height(400.dp)
    .clickable {
        navHostController.navigate(Screen.Details.passPropertyId(propertyId = property.id))
    }){
Surface(shape = RoundedCornerShape(10) ) {
Image(modifier = Modifier.fillMaxSize(),painter =painter , contentDescription ="property image")
}
    Surface(Modifier.fillMaxHeight(0.4f).fillMaxWidth(),
        color = Color.Black.copy(alpha = ContentAlpha.medium),
        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
    ) {

    }
}
}