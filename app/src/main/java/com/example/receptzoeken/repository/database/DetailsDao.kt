package com.example.receptzoeken.repository.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.receptzoeken.repository.Models.DetailModels.DetailModel


@Dao
interface DetailsDao {
    @Insert
    fun insertDetail(detail:DetailModel)

    @Query("SELECT * FROM details_table")
    fun getAllDetail():LiveData<List<DetailModel>>

    @Delete
    fun deleteRecipe(detail: DetailModel)

    @Query("DELETE FROM details_table WHERE id =:idm")
    fun deleteRecipeById(idm:Long)
}