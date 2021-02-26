package com.example.receptzoeken.ui.fragments.favoriete

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.receptzoeken.repository.Models.DetailModels.DetailModel
import com.example.receptzoeken.repository.database.DetailsDao
import com.example.receptzoeken.repository.database.DetailsDatabase
import kotlinx.coroutines.*
import kotlin.coroutines.suspendCoroutine

class FavoriteViewMode(application: Application) :AndroidViewModel(application){

    val dataList = MutableLiveData<List<DetailModel>>()

    private val context = getApplication<Application>().applicationContext

    var dataSource: DetailsDao
    val job = Job()
    val uiScope = CoroutineScope(Dispatchers.Main+job)


    init {
        dataSource = DetailsDatabase.getInstance(context).detailsDatabaseDao()
        //getAllRecipes()
    }


//
//     fun getAllRecipes()  {
//         uiScope.launch {
//             withContext(Dispatchers.IO){
//                 dataList.postValue (dataSource.getAllDetail())
//             }
//         }
//    }

    fun getAllRecipes(): LiveData<List<DetailModel>> {
        return dataSource.getAllDetail()
    }

    fun deleteFavorite(item:DetailModel){
        uiScope.launch {
           withContext(Dispatchers.IO){
               dataSource.deleteRecipe(item)
             //  getAllRecipes()
           }
        }
    }



}