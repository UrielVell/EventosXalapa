package com.example.eventosxalapa

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.eventosxalapa.Models.Evento

class EventoAdapter(val listaEventos:List<Evento>) : RecyclerView.Adapter<EventoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EventoViewHolder(layoutInflater.inflate(R.layout.item_evento, parent, false))
    }

    override fun getItemCount(): Int {
        return listaEventos.size
    }

    override fun onBindViewHolder(holder: EventoViewHolder, position: Int) {
        val item = listaEventos[position]
        holder.render(item)


        holder.guardar.setOnClickListener {
            if (item.isClicked) {
                holder.guardar.setImageResource(R.drawable.full_bookmark_24)
                Toast.makeText(it.context, "Evento guardado", Toast.LENGTH_SHORT).show()
            } else {
                holder.guardar.setImageResource(R.drawable.baseline_bookmark_border_24)
                Toast.makeText(it.context, "Evento quitado de favoritos", Toast.LENGTH_SHORT).show()
            }
            item.isClicked = !item.isClicked
        }

    }
}