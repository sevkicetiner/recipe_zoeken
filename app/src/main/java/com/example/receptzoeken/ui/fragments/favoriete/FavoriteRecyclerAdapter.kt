package com.example.receptzoeken.ui.fragments.favoriete

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.receptzoeken.R
import com.example.receptzoeken.repository.Models.DetailModels.DetailModel
import com.example.receptzoeken.ui.activities.detail.DetailActivity
import com.example.receptzoeken.ui.fragments.favoriete.FavoriteRecyclerAdapter.FavoriteViewHolder
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FavoriteRecyclerAdapter(var dataList:List<DetailModel>, val clickListener: FavoriteItemClickListener) : RecyclerView.Adapter<FavoriteViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite_page, parent,false)

        return FavoriteViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.onBind(dataList[position], clickListener)
    }

    class FavoriteViewHolder (view:View):RecyclerView.ViewHolder(view){
        val view = view
        val imageView = view.findViewById<ImageView>(R.id.image_favorite_item)
        val title = view.findViewById<TextView>(R.id.text_favorite_title)
        val fav = view.findViewById<FloatingActionButton>(R.id.fav_favorite)

        fun onBind(
            model: DetailModel,
            clickListener: FavoriteItemClickListener
        ) {
            Glide.with(itemView.context).load(model.image).into(imageView)
            title.setText(model.title)
            fav.setOnClickListener {
                clickListener.onClick(model)
            }
            view.setOnClickListener {
                val intent = Intent(it.context, DetailActivity::class.java)
                Log.e("favorite id", model.id.toString())
                intent.putExtra("id", model.id)
                it.context.startActivity(intent)
            }
        }


    }

    class FavoriteItemClickListener(val clickListener:(model:DetailModel)->Unit){
        fun onClick(item:DetailModel)=clickListener(item)
    }
}


