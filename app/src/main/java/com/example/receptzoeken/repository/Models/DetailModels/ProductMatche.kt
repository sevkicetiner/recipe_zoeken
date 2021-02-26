package com.example.receptzoeken.repository.Models.DetailModels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ProductMatche")
data class ProductMatche(
    val averageRating: Double,
    val description: String,
    @PrimaryKey
    val id: Int,
    val imageUrl: String,
    val link: String,
    val price: String,
    val ratingCount: Double,
    val score: Double,
    val title: String
)