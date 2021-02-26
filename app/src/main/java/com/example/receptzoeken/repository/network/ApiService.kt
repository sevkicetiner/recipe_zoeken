package com.example.receptzoeken.repository.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

      val BASE_URL = "https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/"


        val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val client : OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()

        //val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        fun getService(): SpoonacularService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(LiveDataCallAdapterFactory())
                .client(client)
                .build()
                .create(SpoonacularService::class.java)
        }



}