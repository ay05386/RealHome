package com.example.realhome.domain.model

import android.media.Rating
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.realhome.util.Constants.PROPERTY_DATABASE_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = PROPERTY_DATABASE_TABLE)
data class Property(
    @PrimaryKey
    val id : Int,
    val title :String,
    val price: Int,
    val Description :String,
    val type : String,
    val bedrooms :Int,
    val bathrooms:Int,
    val image:String,
    val rating: Double
)
