package com.example.receptzoeken.ui.activities.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.receptzoeken.R
import com.example.receptzoeken.repository.Models.DetailModels.ExtendedIngredient

class DetailRecyclerAdapter(val dataList:List<ExtendedIngredient>) :RecyclerView.Adapter<DetailRecyclerAdapter.DetailViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ingredients, parent, false)
        return DetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        println(dataList[position].image)
        Glide.with(holder.itemView.context).load("https://spoonacular.com/cdn/ingredients_100x100/"+dataList[position].image).into(holder.image)
        holder.nameIngr.setText(dataList[position].name)
        holder.olcu.setText(dataList[position].amount.toString() +" "+dataList[position].unit)
    }

    class DetailViewHolder(view:View): RecyclerView.ViewHolder(view){
        val image = view.findViewById<ImageView>(R.id.image_ingredient_item)
        val nameIngr = view.findViewById<TextView>(R.id.text_name_ingredient_item)
        val olcu = view.findViewById<TextView>(R.id.text_olcu_ingredient_item)
    }
}