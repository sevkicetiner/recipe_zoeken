package com.example.receptzoeken.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.receptzoeken.ui.fragments.favoriete.FavorieteFragment
import com.example.receptzoeken.ui.fragments.random.RandomFragment
import com.example.receptzoeken.ui.fragments.zoeken.ZoekenFragment

class MyPagerAdapter(fragmentManager: FragmentManager, val fragmentList:List<Fragment>)
    : FragmentStatePagerAdapter(fragmentManager) {


    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> ZoekenFragment()
            1-> RandomFragment()
            else -> FavorieteFragment()
        }
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {

        //return super.getPageTitle(position)
        return when(position){
            0-> "Find Recipe"
            1-> "Random"
            else -> "Favorite"
        }
    }
}