package com.example.eventosxalapa

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.eventosxalapa.Models.Evento

class EventoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val nomEvento = view.findViewById<TextView>(R.id.nomEvento)
    val descEvento = view.findViewById<TextView>(R.id.descEvento)
    val imgEvento = view.findViewById<ImageView>(R.id.imgEvento)
    val precio = view.findViewById<TextView>(R.id.txtPrecio)
    val guardar = view.findViewById<ImageButton>(R.id.btnGuardar)

    private var isButtonClicked = false
    fun render (evento: Evento ){
        nomEvento.text = evento.nombre
        descEvento.text = evento.descripcion
        precio.text = evento.precio
        Glide.with(imgEvento.context).load(evento.imagen).into(imgEvento)

    }
}