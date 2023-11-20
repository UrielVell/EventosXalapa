package com.example.eventosxalapa.Controlers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eventosxalapa.Models.ClassEvento
import com.example.eventosxalapa.Models.EventosProvider
import com.example.eventosxalapa.R

class EventosAdapter(private val listaEventos: List<ClassEvento>) : RecyclerView.Adapter<EventosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventosViewHolder {
        val LayoutInflater = LayoutInflater.from(parent.context)
        return  EventosViewHolder(LayoutInflater.inflate(R.layout.item_evento, parent, false))
    }

    override fun getItemCount(): Int {
        return listaEventos.size
    }

    override fun onBindViewHolder(holder: EventosViewHolder, position: Int) {
        val item = listaEventos[position]
        holder.render(item)
    }

}