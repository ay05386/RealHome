package com.example.realhome.presentation.components

import android.annotation.SuppressLint
import android.media.Rating
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.realhome.R
import com.example.realhome.ui.theme.starColor

@Composable
fun ratingWidget(modifier: Modifier,rating: Double,scaleFactor:Float=1f,spaceBetween: Dp =6.dp){
    val result= calculateStars(rating = rating)
val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(starPathString).toPath()
    }
    val starPathbounds = remember {
        starPath.getBounds()
    }

    Row (modifier= modifier, horizontalArrangement = Arrangement.spacedBy(spaceBetween)){
     result["filledStars"]?.let {
         repeat(it){
             filledStar(starPath = starPath, starPathBounds = starPathbounds, scaleFactor = scaleFactor)
         }
     }
        result["halfFilledStars"]?.let {
            repeat(it){
                halfFielldStar(starPath = starPath, starPathBounds = starPathbounds, scaleFactor = scaleFactor)
            }
        }
        result["emptyStars"]?.let {
            repeat(it){
                emptyStar(starPath = starPath, starPathBounds = starPathbounds, scaleFactor = scaleFactor)
            }
        }
    }

}

@Composable
fun filledStar(starPath:Path,starPathBounds:Rect,scaleFactor:Float){
    Canvas(modifier = Modifier.size(24 .dp)){
        val canvasSize= size
        scale(scale=scaleFactor){
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width/2)-(pathWidth/2)
            val top = (canvasSize.height/2)-(pathHeight/2)
            translate(left=left, top = top) {
                drawPath(
                    path = starPath,
                    color = starColor
                )
            }
        }

    }

}



@Composable
fun emptyStar(starPath:Path,starPathBounds:Rect,scaleFactor:Float){
    Canvas(modifier = Modifier.size(24.dp)){
        val canvasSize= size
        scale(scale=scaleFactor){
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width/2)-(pathWidth/2)
            val top = (canvasSize.height/2)-(pathHeight/2)
            translate(left=left, top = top) {
                drawPath(
                    path = starPath,
                    color = Color.LightGray.copy(alpha = 0.5f)
                )
            }
        }

    }
}

@Composable
fun halfFielldStar(starPath:Path,starPathBounds:Rect,scaleFactor:Float){
    Canvas(modifier = Modifier.size(24.dp)){
        val canvasSize= size
        scale(scale=scaleFactor){
            val pathWidth = starPathBounds.width
            val pathHeight = starPathBounds.height
            val left = (canvasSize.width/2)-(pathWidth/2)
            val top = (canvasSize.height/2)-(pathHeight/2)
            translate(left=left, top = top) {
                drawPath(
                    path = starPath,
                    color = Color.LightGray.copy(alpha = 0.5f)
                )
                clipPath(path = starPath){
                    drawRect(
                        color = starColor,
                        size= Size(
                            width = starPathBounds.width/2f,
                            height = starPathBounds.height/1f

                        )
                    )
                }
            }
        }

    }
}


@SuppressLint("SuspiciousIndentation")
@Composable
fun calculateStars(rating: Double):Map<String,Int>{
    val maxvalue by remember {
        mutableStateOf(5)
    }
    var filledStars by remember {
        mutableStateOf(0)
    }
    var halfFilledStars by remember {
        mutableStateOf(0)
    }
    var emptyStars by remember {
        mutableStateOf(0)
    }
    LaunchedEffect(key1 = rating){
        val (firstNumber,lastNumber)= rating.toString().split(".").
                map { it.toInt() }
        if (firstNumber in 0..9&&lastNumber in 0..5){
      filledStars= firstNumber
            if (lastNumber in 1..5){
                halfFilledStars++
            }
            if (lastNumber in 6..9){
                filledStars++
            }
            if (firstNumber ==5&& lastNumber>0){
                filledStars=0
                halfFilledStars=0
                emptyStars=5
            }
        }else{
            Log.d("rating widget","invalid rating number")
        }




    }
    emptyStars = maxvalue - (filledStars+halfFilledStars)
    return mapOf(
      "filledStars" to filledStars
        ,"halfFilledStars" to halfFilledStars,
        "emptyStars" to emptyStars



    )
}



@Composable
@Preview(showBackground = true)
fun filledStarPreview(){
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(starPathString).toPath()
    }
    val starPathbounds = remember {
        starPath.getBounds()
    }
    filledStar(starPath =starPath , starPathBounds =starPathbounds,scaleFactor=3f )
}
@Composable
@Preview(showBackground = true)
fun halfFilledStarPreview(){
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(starPathString).toPath()
    }
    val starPathbounds = remember {
        starPath.getBounds()
    }
    halfFielldStar(starPath =starPath , starPathBounds =starPathbounds,scaleFactor=3f)
}
@Composable
@Preview(showBackground=true)
fun emptyStarPreview(){
    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(starPathString).toPath()
    }
    val starPathbounds = remember {
        starPath.getBounds()
    }
    emptyStar(starPath =starPath , starPathBounds =starPathbounds,scaleFactor=3f)
}