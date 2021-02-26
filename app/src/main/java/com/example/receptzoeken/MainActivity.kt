package com.example.receptzoeken

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.example.receptzoeken.ui.fragments.favoriete.FavorieteFragment
import com.example.receptzoeken.ui.fragments.random.RandomFragment
import com.example.receptzoeken.ui.fragments.zoeken.ZoekenFragment
import com.example.receptzoeken.utils.MyPagerAdapter
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val databseState=MutableLiveData<Boolean>()
    lateinit var mAdView:AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this)
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        val fragmentList = listOf<Fragment>(
            ZoekenFragment(),
            RandomFragment(),
            FavorieteFragment()
        )

        viewpager.adapter = MyPagerAdapter(
            supportFragmentManager,
            fragmentList
        )
        tablayout.setupWithViewPager(viewpager)
        databseState.postValue(false)
    }
}
