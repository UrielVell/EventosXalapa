package com.example.eventosxalapa.Controlers

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.eventosxalapa.Models.ClassEvento
import com.example.eventosxalapa.R

class EventosViewHolder (view: View): RecyclerView.ViewHolder(view){
    val imgEvento = view.findViewById<ImageView>(R.id.imgEvento)
    val nomEvento = view.findViewById<TextView>(R.id.nomEvento)
    val descEvento = view.findViewById<TextView>(R.id.descEvento)

    fun render(evento: ClassEvento){
        nomEvento.text = evento.nombreEvento
        descEvento.text = evento.descEvento
        Glide.with(imgEvento.context).load(evento.imgEvento).into(imgEvento)
    }
}