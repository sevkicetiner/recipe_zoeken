package com.example.receptzoeken.repository.Models.DetailModels

import androidx.room.Embedded
import androidx.room.Entity

@Entity(tableName = "AnalyzedInstructions")
data class AnalyzedInstruction(
    val name: String,
    @Embedded
    val steps: List<Step>
)