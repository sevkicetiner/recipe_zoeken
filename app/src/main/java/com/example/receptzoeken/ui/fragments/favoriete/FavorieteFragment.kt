package com.example.receptzoeken.ui.fragments.favoriete


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.example.receptzoeken.MainActivity

import com.example.receptzoeken.R
import com.example.receptzoeken.repository.Models.DetailModels.DetailModel
import kotlinx.android.synthetic.main.fragment_favoriete.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.internal.notifyAll

/**
 * A simple [Fragment] subclass.
 */
class FavorieteFragment : Fragment() {

    lateinit var viewModel: FavoriteViewMode
    lateinit var adapter:FavoriteRecyclerAdapter
    private var datalist:List<DetailModel> = emptyList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favoriete, container, false)
        viewModel = ViewModelProviders.of(this).get(FavoriteViewMode::class.java)

        viewModel.getAllRecipes().observe(this, Observer {datalist->
            adapter = FavoriteRecyclerAdapter(datalist, FavoriteRecyclerAdapter.FavoriteItemClickListener {
                viewModel.deleteFavorite(it)
            })
            recycler_favorite.adapter = adapter
        })

        return view
    }
}
