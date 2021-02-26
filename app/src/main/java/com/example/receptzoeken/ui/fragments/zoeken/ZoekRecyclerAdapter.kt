package com.example.receptzoeken.ui.fragments.zoeken

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.receptzoeken.R
import com.example.receptzoeken.repository.Models.ZoekModels.ResultSpoonacular
import com.example.receptzoeken.repository.Models.ZoekModels.SpoonacularModel

class ZoekRecyclerAdapter(val data: SpoonacularModel, val listener: ZoekItemListener): RecyclerView.Adapter<ZoekRecyclerAdapter.ZoekViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZoekViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.zoek_list_item, parent, false )
        return ZoekViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.results.size
    }

    override fun onBindViewHolder(holder: ZoekViewHolder, position: Int) {

        data.results[position].image?.let {
            //val imgUri = it.toUri().buildUpon().scheme("https").build()
            Glide.with(holder.imageView.context)
                .load(data.baseUri+data.results[position].image)
                .into(holder.imageView)
        }

        holder.title.setText(data.results[position].title)

        holder.itemView.setOnClickListener {
            listener.onClick(data.results[position])
        }

    }

    class ZoekViewHolder(view:View): RecyclerView.ViewHolder(view){
        val imageView = view.findViewById<ImageView>(R.id.imageview_zoek_item)
        val title = view.findViewById<TextView>(R.id.textview_zoek_item)
    }

    class ZoekItemListener(val clicklistener:(result:ResultSpoonacular)->Unit){
        fun onClick(item:ResultSpoonacular)= clicklistener(item)
    }
}
