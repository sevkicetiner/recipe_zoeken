package com.example.receptzoeken.repository.database

import android.content.Context
import androidx.room.*
import com.example.receptzoeken.repository.Models.DetailModels.*


@Database(entities = [DetailModel::class,
    //AnalyzedInstruction::class,
    ExtendedIngredient::class
//    Ingredient::class,
//    Length::class,
//Measures::class,
//Metric::class,
//ProductMatche::class,
//Step::class,
//Us::class,
//WinePairing::class
], version = 2, exportSchema = false)
abstract class DetailsDatabase :RoomDatabase() {

    abstract fun detailsDatabaseDao():DetailsDao

    companion object {

        private var INSTANCE : DetailsDatabase?=null

        fun getInstance(context: Context):DetailsDatabase{
            synchronized(this){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DetailsDatabase::class.java,
                        "details_database_new"
                    ).fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()

                }
                return INSTANCE!!
            }
        }
    }
}