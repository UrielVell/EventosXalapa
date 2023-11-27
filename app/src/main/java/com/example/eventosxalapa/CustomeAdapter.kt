package com.example.eventosxalapa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eventosxalapa.Models.EventosProvider

class CustomeAdapter: RecyclerView.Adapter<CustomeAdapter.ViewHolder>(){

    val titulos = listOf<String>("adasd")
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_evento, viewGroup, false)
        return ViewHolder(v)
        }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

    }

    override fun getItemCount(): Int {
       return titulos.size
    }

        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            var nombreEvento : TextView
            var descEvento : TextView
            var imgEvento : ImageView
            var precio : TextView

            init{
                nombreEvento = itemView.findViewById(R.id.nomEvento)
                descEvento = itemView.findViewById(R.id.descEvento)
                imgEvento = itemView.findViewById(R.id.imgEvento)
                precio = itemView.findViewById(R.id.txtPrecio)
            }
        }
}