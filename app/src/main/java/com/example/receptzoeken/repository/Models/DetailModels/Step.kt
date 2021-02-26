package com.example.receptzoeken.repository.Models.DetailModels

import androidx.room.Embedded
import androidx.room.Entity

@Entity(tableName = "Step")
data class Step(
    @Embedded
    val equipment: List<Any>,
    @Embedded
    val ingredients: List<Ingredient>,
    val length: Length?,
    val number: Int,
    val step: String
)