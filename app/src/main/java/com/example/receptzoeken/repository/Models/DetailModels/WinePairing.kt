package com.example.receptzoeken.repository.Models.DetailModels

import androidx.room.Embedded
import androidx.room.Entity

@Entity(tableName = "WinePrairing")
data class WinePairing(
    @Embedded
    val pairedWines: List<String>?,
    @Embedded
    val pairingText: String?,
    val productMatches: List<ProductMatche>?
)