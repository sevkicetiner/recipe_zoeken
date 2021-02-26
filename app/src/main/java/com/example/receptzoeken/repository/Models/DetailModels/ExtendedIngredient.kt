package com.example.receptzoeken.repository.Models.DetailModels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ExtendedIngredient")
data class ExtendedIngredient(
    //var aisle: String,
    var amount: Double = 0.0,
   // var consitency: String,
    @PrimaryKey
    var id: Int = 0 ,
    var image: String = "",
   // var measures: Measures,
//
//    var meta: List<Any>,
//    var metaInformation: List<Any>,
    var name: String ="",
//    var original: String,
//    var originalName: String,
//    var originalString: String,
    var unit: String=""
){
    public constructor() : this(0.0, 0, "", "", "")
}