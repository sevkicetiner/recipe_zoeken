package com.example.receptzoeken.ui.activities.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.receptzoeken.R
import com.example.receptzoeken.repository.Models.DetailModels.DetailModel
import com.example.receptzoeken.repository.database.DetailsDao
import com.example.receptzoeken.repository.database.DetailsDatabase
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.*

class DetailActivity : AppCompatActivity() {
    lateinit var datasource: DetailsDao
    lateinit var viewModel:DetailViewModel
    lateinit var mAdView:AdView
//    val job = Job()
//    val uiScope = CoroutineScope(Dispatchers.Main+job)
    var favoriteIcon:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        MobileAds.initialize(this)
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        //val toolbar = findViewById<Toolbar>(R.id.toolbar_detail)
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)



        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        val id  = intent.getLongExtra("id",0L)
        Log.e("DETAIL ID ", id.toString() )
        viewModel.getDetails(id)
        viewModel.json.observe(this, Observer {

            Log.e("gelen DataModel", it.image)

            Glide.with(this).load(it.image).into(image_detail_main)
            textview_detail_intraduction.setText(it.instructions)
//            if (it.title!!.length>34){
//                supportActionBar?.setTitle(it.subSequence(0,33))
//                supportActionBar?.setSubtitle(it.title.subSequence(34, it.title.length))
//            }else{
//                supportActionBar?.setTitle(it.title)
//            }


            recycler_detail_ingredient.adapter = DetailRecyclerAdapter(it.extendedIngredients)

        })


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //return super.onOptionsItemSelected(item)
        if (item?.itemId == R.id.menu_item_favorite){
            favoriteIcon = !favoriteIcon
            if (favoriteIcon) {
                item.setIcon(R.drawable.ic_favorite_black_24dp)
                viewModel.addFavorite()
            }
            else{
                item.setIcon(R.drawable.ic_favorite_border_black_24dp)
                viewModel.deleteFavorite()
            }

            return true
        }

        if(item?.itemId == android.R.id.home){
            onBackPressed()
            return true
        }
        else return super.onOptionsItemSelected(item)
    }
}
