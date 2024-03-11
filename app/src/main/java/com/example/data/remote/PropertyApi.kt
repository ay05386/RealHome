package com.example.data.remote

import com.example.realhome.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PropertyApi {
    @GET("/RealHomes/Properites")
    suspend fun getallproperties(
        @Query("page") page:Int = 1
    ):ApiResponse

    @GET("/RealHomes/Properites/search")
    suspend fun searchProperty(
        @Query("name")name:String
    ):ApiResponse
}