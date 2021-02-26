package com.example.receptzoeken.repository.Models.DetailModels

import androidx.room.Entity

@Entity(tableName = "Us")
data class Us(
    val amount: Double,
    val unitLong: String,
    val unitShort: String
)