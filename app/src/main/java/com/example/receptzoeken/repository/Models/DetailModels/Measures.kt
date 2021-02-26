package com.example.receptzoeken.repository.Models.DetailModels

import androidx.room.Entity

@Entity(tableName = "Measures")
data class Measures(
    val metric: Metric,
    val us: Us
)