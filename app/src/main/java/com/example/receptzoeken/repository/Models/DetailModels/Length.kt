package com.example.receptzoeken.repository.Models.DetailModels

import androidx.room.Entity

@Entity(tableName = "Length")
data class Length(
    val number: Int,
    val unit: String
)