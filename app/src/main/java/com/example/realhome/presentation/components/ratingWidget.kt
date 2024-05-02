package com.example.realhome.presentation.components

import android.media.Rating
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.realhome.R
import com.example.realhome.ui.theme.starColor

@Composable
fun ratingWidget(modifier: Modifier,rating: Double,scaleFactor:Float=3f){
val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(starPathString).toPath()
    }
    val starPathbounds = remember {
        starPath.getBounds()
    }
filledStar(starPath = starPath, starPathBounds = starPathbounds,scaleFactor=3f)
}

@Composable
fun filledStar(starPath:Path,starPathBounds:Rect,scaleFactor:Float){
    Canvas(modifier = Modifier.size(100.dp)){
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
    Canvas(modifier = Modifier.size(100.dp)){
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
    Canvas(modifier = Modifier.size(100.dp)){
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

/*
@Composable
fun calculateStars():Map<String,Int>{

}


*/
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