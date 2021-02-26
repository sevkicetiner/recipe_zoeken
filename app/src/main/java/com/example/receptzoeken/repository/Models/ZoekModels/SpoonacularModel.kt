package com.example.receptzoeken.repository.Models.ZoekModels


data class SpoonacularModel (
    val results:List<ResultSpoonacular>,
    val totalResults:Int,
    val baseUri:String,
    val offset:Int,
    val number:Int
)