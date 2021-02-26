package com.example.receptzoeken.ui.activities.detail

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.receptzoeken.repository.Models.DetailModels.DetailModel
import com.example.receptzoeken.repository.database.DetailsDao
import com.example.receptzoeken.repository.database.DetailsDatabase
import com.example.receptzoeken.repository.network.ApiService
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel(application: Application): AndroidViewModel(application) {

    val json = MutableLiveData<DetailModel>()
    val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main+job)

    val context = getApplication<Application>().applicationContext

    val datasource:DetailsDao

    init {
       datasource = DetailsDatabase.getInstance(context).detailsDatabaseDao()
    }


    fun getDetails(id:Long){
        ApiService().getService().getDetailById(id).enqueue(object :Callback<DetailModel>{
            override fun onFailure(call: Call<DetailModel>, t: Throwable) {
                Log.e("onFailure", t.message)
            }

            override fun onResponse(call: Call<DetailModel>, response: Response<DetailModel>) {
                json.postValue(response.body())
            }
        })
    }


    fun addFavorite(){
        uiScope.launch {
            withContext(Dispatchers.IO){

                datasource.insertDetail(json.value!!)
            }
        }
    }
    fun deleteFavorite(){
        uiScope.launch {
            withContext(Dispatchers.IO){
                datasource.deleteRecipe(json.value!!)
            }
        }
    }
}