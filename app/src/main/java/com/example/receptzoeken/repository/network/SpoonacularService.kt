package com.example.receptzoeken.repository.network

import com.example.receptzoeken.repository.Models.DetailModels.DetailModel
import com.example.receptzoeken.repository.Models.RandomModels.RandomModel
import com.example.receptzoeken.repository.Models.ZoekModels.SpoonacularModel
import com.example.receptzoeken.utils.*
import retrofit2.Call
import retrofit2.http.*

//https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/search
// ?diet=vegetarian
// &excludeIngredients=coconut
// &intolerances=egg%252C+gluten
// &number=10
// &offset=0
// &type=main+course
// &query=burger


interface SpoonacularService {

    @Headers( "X-RapidAPI-Host: spoonacular-recipe-food-nutrition-v1.p.rapidapi.com",
    "X-RapidAPI-Key: ba8909f054msh4e7dafbbe053557p1de9bajsnff0afa309fdb",
        "Content-Type: application/json",
        "Accept: application/json"
        )
    @GET("recipes/search")
    fun recipesSearch(
        @Query("query") query:String,
        @Query("diet") diet:diet? =  null,
        @Query("type") type:type? = null,
        @Query("cuisine") cuisine:cuisine? = null,
        @Query("number") number:Int = 30,
        @Query("ofset") offset:Int = 0,
        @Query("intolerances") intolerances: intolerances? = null,
        @Query("instructionsRequired") instructionsRequired:Boolean? = null
        ) : Call<SpoonacularModel>


    @Headers( "X-RapidAPI-Host: spoonacular-recipe-food-nutrition-v1.p.rapidapi.com",
        "X-RapidAPI-Key: ba8909f054msh4e7dafbbe053557p1de9bajsnff0afa309fdb",
        "Content-Type: application/json",
        "Accept: application/json")
    @GET("recipes/{id}/information")
    fun getDetailById(@Path("id") id:Long):Call<DetailModel>

    @Headers( "X-RapidAPI-Host: spoonacular-recipe-food-nutrition-v1.p.rapidapi.com",
        "X-RapidAPI-Key: ba8909f054msh4e7dafbbe053557p1de9bajsnff0afa309fdb",
        "Content-Type: application/json",
        "Accept: application/json")
    @GET("recipes/random")
    fun getRandomRecipe():Call<RandomModel>
}