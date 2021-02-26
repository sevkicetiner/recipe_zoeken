package com.example.receptzoeken.repository.Models.ZoekModels


data class ResultSpoonacular (
    val id:Long = 0L,
    val title:String,
    val readyInMinutes:Int,
    val servings:Int,
    val image:String,
    val imageUrls:List<String>
)

