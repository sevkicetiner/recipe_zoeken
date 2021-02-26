package com.example.receptzoeken.repository.Models.DetailModels

import androidx.room.*
import java.io.Serializable

@Entity(tableName = "details_table")
data class DetailModel(
    //var aggregateLikes: Int,
//    @Embedded
//    var analyzedInstructions: List<AnalyzedInstruction>?,
    //var cheap: Boolean,
    //var creditsText: String,
//    @Embedded
//    var cuisines: List<String>,
//    var dairyFree: Boolean,
//    @Embedded
//    var diets: List<String>,
//    @Embedded
//    var dishTypes: List<String>,
    @Ignore
    var extendedIngredients: List<ExtendedIngredient> = emptyList(),
    var gaps: String?,
    var glutenFree: Boolean?,
    var healthScore: Double?,
    @PrimaryKey(autoGenerate = false)
    var id: Long?,
    var image: String?,
    //var imageType: String,
    var instructions: String?,
    //var lowFodmap: Boolean,
//    @Embedded
//    var occasions: List<Any>,
    var pricePerServing: Double?,
    var readyInMinutes: Int?,
    var servings: Int?,
    var sourceName: String?,
    var sourceUrl: String?,
    var spoonacularScore: Double?,
    var spoonacularSourceUrl: String?,
    var sustainable: Boolean?,
    var title: String?,
    var vegan: Boolean?,
    var vegetarian: Boolean?,
    var veryHealthy: Boolean?,
    var veryPopular: Boolean?,
    var weightWatcherSmartPoints: Int?
//    var winePairing: WinePairing?

)
{
    public constructor():this(
        emptyList(), null, null, null ,
        null , null , null , null , null ,
                null , null , null, null ,
        null, null, null, null ,
        null, null, null, null )
}