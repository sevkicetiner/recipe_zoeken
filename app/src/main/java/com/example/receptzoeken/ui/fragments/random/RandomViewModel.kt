package com.example.receptzoeken.ui.fragments.random

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.receptzoeken.repository.Models.DetailModels.DetailModel
import com.example.receptzoeken.repository.Models.RandomModels.RandomModel
import com.example.receptzoeken.repository.database.DetailsDao
import com.example.receptzoeken.repository.database.DetailsDatabase
import com.example.receptzoeken.repository.network.ApiService
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.sql.DataSource

class RandomViewModel(application:Application) : AndroidViewModel(application) {
    val data = MutableLiveData<RandomModel>()

    private val context = getApplication<Application>().applicationContext

    var dataSource: DetailsDao
    val job = Job()
    val uiScope = CoroutineScope(Dispatchers.Main+job)


    init {
        dataSource = DetailsDatabase.getInstance(context).detailsDatabaseDao()
    }


    fun getRandomRecipe(){
        ApiService().getService().getRandomRecipe().enqueue(object : Callback<RandomModel>{
            override fun onFailure(call: Call<RandomModel>, t: Throwable) {
                Log.e("RandomRecipe", t.message)
            }

            override fun onResponse(call: Call<RandomModel>, response: Response<RandomModel>) {
                data.postValue(response.body())
            }
        })
    }

    fun addFavorities(detailModel: DetailModel){
        uiScope.launch {
            withContext(Dispatchers.IO){
                dataSource.insertDetail(detailModel)
            }
        }
    }

    fun deleteFavorite(item:DetailModel){
        uiScope.launch {
            withContext(Dispatchers.IO){
                dataSource.deleteRecipe(item)
            }
        }
    }


    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }
}