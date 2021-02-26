package com.example.receptzoeken.repository.Models.DetailModels

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Ingredient")
data class Ingredient(
    @PrimaryKey
    val id: Int,
    val image: String,
    val name: String
)