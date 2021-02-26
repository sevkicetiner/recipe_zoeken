package com.example.receptzoeken.ui.fragments.zoeken

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.receptzoeken.repository.Models.ZoekModels.SpoonacularModel
import com.example.receptzoeken.repository.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ZoekViewModel : ViewModel() {

    val mutableList = MutableLiveData<SpoonacularModel>()

    fun SearchRecipes(query:String){
        val apicleint = ApiService().getService()
        apicleint.recipesSearch(query = query).enqueue( object :
            Callback<SpoonacularModel> {
            override fun onFailure(call: Call<SpoonacularModel>, t: Throwable) {
                Log.e("ResponseError",t.message)
            }

            override fun onResponse(call: Call<SpoonacularModel>, response: Response<SpoonacularModel>) {
                val cevap : SpoonacularModel? = response.body()
                mutableList.postValue(cevap)
            }
        })
    }
}