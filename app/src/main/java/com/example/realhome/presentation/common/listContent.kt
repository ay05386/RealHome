package com.example.realhome.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.Pager
import androidx.paging.compose.LazyPagingItems
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import com.example.realhome.R
import com.example.realhome.domain.model.Property
import com.example.realhome.navigation.Screen
import com.example.realhome.presentation.components.ratingWidget
import com.example.realhome.ui.theme.topAppbarcontentcolor
import com.example.realhome.util.Constants.BASE_URL
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import com.google.accompanist.pager.rememberPagerState
import androidx.paging.PagingData
import androidx.paging.compose.items


@ExperimentalCoilApi
@Composable
fun listContent(propertys: LazyPagingItems<Property>,navHostController: NavHostController){
LazyColumn(contentPadding = PaddingValues(all =10.dp),
    verticalArrangement = Arrangement.spacedBy(10.dp)){
  items(
      items = propertys,
      key = {property->property.id}){
property->property?.let { Propertyitem(property = it, navHostController = navHostController) }
  }
}

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
    }, contentAlignment = Alignment.BottomStart){
Surface(shape = RoundedCornerShape(10) ) {
Image(modifier = Modifier.fillMaxSize(),painter =painter , contentDescription ="property image")
}
    Surface(
        Modifier
            .fillMaxHeight(0.4f)
            .fillMaxWidth(),
        color = Color.Black.copy(alpha = ContentAlpha.medium),
        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
    ) {
         Column(modifier = Modifier
             .fillMaxSize()
             .padding(all = 15.dp)) {
          Text(text = property.title,
              color = MaterialTheme.colors.topAppbarcontentcolor,
              fontSize = MaterialTheme.typography.h5.fontSize,
              fontWeight = FontWeight.Bold,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis)
             Text(text = property.Description,
                 color = Color.White.copy(alpha = ContentAlpha.medium),
                 fontSize = MaterialTheme.typography.h5.fontSize,
                 maxLines = 3,
                 overflow = TextOverflow.Ellipsis)
             Row (modifier = Modifier.padding(10.dp), 
                 verticalAlignment = Alignment.CenterVertically){
               ratingWidget(modifier = Modifier.padding(end = 10.dp), rating = property.rating)
                 Text(text = "${property.rating}",
                     textAlign = TextAlign.Center,
                     color = Color.White.copy(alpha = ContentAlpha.medium))
             }
         }
    }
}
}
@ExperimentalCoilApi
@Composable
@Preview
fun prev(){
Propertyitem(property = Property(
    id = 1,
    title = "apartment",
    image = "",
    Description = "some text",
    rating = 4.2,
    type = "residential",
    bathrooms = 3,
    bedrooms = 4,
    price = 300000), navHostController = rememberNavController())
}