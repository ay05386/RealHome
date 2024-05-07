package com.example.realhome.navigation

sealed class Screen(val route:String) {
    object Splash:Screen("splash_screen")
    object Welcome:Screen("welcome_screen")
    object Home:Screen("home_screen")
    object Details:Screen("details_screen/{propertyid}"){
        fun passPropertyId(propertyId:Int):String{
            return "details_screen/$propertyId"
        }
    }

    object search:Screen("search_screen")


}