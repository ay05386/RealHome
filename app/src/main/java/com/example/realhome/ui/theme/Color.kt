package com.example.realhome.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0x9C27B0)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val starColor = Color(0xFFFFC94D)
val Colors.topAppbarcontentcolor:Color
@Composable
get() = if (isLight) Color.White else Color.LightGray

val Colors.topappbarbackgroundcolor:Color
@Composable
get() = if (isLight) Purple40 else Color.Black