package com.example.androiddeveloper.model

import android.content.Context
import android.renderscript.ScriptGroup
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androiddeveloper.R
import kotlinx.android.synthetic.main.adapter_movie.view.*

class MainAdapter :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    class MainViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    var dataMenu = mutableListOf<dataMenu>()
    fun setMovieList(movies: List<dataMenu>) {
        this.dataMenu = movies.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_movie,parent,false))
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = dataMenu[position]
        holder.view.name.text = movie.value.asJsonObject.get("label").toString()
        System.out.println("date : " + movie.key)
        System.out.println("label : " + movie.value.asJsonObject.get("label").toString())
        System.out.println("nb_visits : " + movie.value.asJsonObject.get("nb_visits").toString())
        System.out.println("status : " + "gaonok field e")
//        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.view.imageview)
    }
    override fun getItemCount(): Int {
        return dataMenu.size
    }
}