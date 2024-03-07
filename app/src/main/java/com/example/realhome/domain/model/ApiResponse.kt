package com.example.realhome.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success:Boolean,
    val message : String?=null,
    val nextpage:Int?=null,
    val prevpage:Int?=null,
    val properties:List<Property> = emptyList(),
)

