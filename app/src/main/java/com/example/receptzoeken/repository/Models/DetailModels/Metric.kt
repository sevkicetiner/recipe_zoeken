package com.example.receptzoeken.repository.Models.DetailModels

import androidx.room.Entity

@Entity(tableName = "Metric")
data class Metric(
    val amount: Double,
    val unitLong: String,
    val unitShort: String
)