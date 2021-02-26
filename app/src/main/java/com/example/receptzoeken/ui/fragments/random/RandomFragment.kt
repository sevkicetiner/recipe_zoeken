package com.example.receptzoeken.ui.fragments.random


import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.receptzoeken.MainActivity

import com.example.receptzoeken.R
import com.example.receptzoeken.repository.Models.RandomModels.RandomModel
import com.example.receptzoeken.ui.activities.detail.DetailRecyclerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_random.*
import kotlinx.android.synthetic.main.item_favorite_page.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class RandomFragment : Fragment() {

    lateinit var button:FloatingActionButton
    lateinit var constrainMain:ConstraintLayout
    lateinit var viewModel: RandomViewModel
    lateinit var imageView: ImageView
    lateinit var textView: TextView
    lateinit var textViewTitle: TextView
    lateinit var recyclerIngredient:RecyclerView
    lateinit var fab:FloatingActionButton
    var status:Boolean = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_random, container, false)
        constrainMain = view.findViewById(R.id.constrain_detail_main)
       button =  view.findViewById(R.id.button_random)
        imageView = view.findViewById(R.id.image_random_main)
        textView = view.findViewById(R.id.textview_random_intraduction)
        textViewTitle = view.findViewById(R.id.text_random_title)
        recyclerIngredient = view.findViewById(R.id.recycler_random_ingredient)
        fab = view.findViewById(R.id.floataction_random)
        constrainMain.visibility = View.GONE


        viewModel = ViewModelProviders.of(this).get(RandomViewModel::class.java)

        button.setOnClickListener {
            status = false
            fab.setImageResource(R.drawable.ic_favorite_border_black_24dp)
            viewModel.getRandomRecipe()

        }

        viewModel.data.observe(this, Observer { randomData ->
            textViewTitle.setText(randomData.recipes[0].title)
            Glide.with(this).load(randomData.recipes[0].image).into(image_random_main)
            textview_random_intraduction.setText(randomData.recipes[0].instructions)

            recyclerIngredient.adapter = DetailRecyclerAdapter(randomData.recipes[0].extendedIngredients)


            fab.setOnClickListener {
                status = !status
                if (status) {
                    fab.setImageResource(R.drawable.ic_favorite_black_24dp)
                     viewModel.addFavorities(randomData.recipes[0])

                }
                else {
                    fab.setImageResource(R.drawable.ic_favorite_border_black_24dp)
                    viewModel.deleteFavorite(randomData.recipes[0])
                }
                (activity as MainActivity).databseState.value = true
            }
            constrainMain.visibility = View.VISIBLE
        })
        return view
    }

}
