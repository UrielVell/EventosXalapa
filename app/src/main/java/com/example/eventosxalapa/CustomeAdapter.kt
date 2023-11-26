package com.example.eventosxalapa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomeAdapter: RecyclerView.Adapter<CustomeAdapter.ViewHolder>(){

    val titles = arrayOf("primero", "segundo","tercero")

    val details = arrayOf("detalle1", "detalle2","Uriel joto")

    val images = intArrayOf(R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
        }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetails.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
       return titles.size
    }

        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            var itemImage: ImageView
            var itemTitle: TextView
            var itemDetails: TextView

            init{
                itemImage = itemView.findViewById(R.id.item_imagen)
                itemTitle=itemView.findViewById(R.id.tv_titulo)
                itemDetails=itemView.findViewById(R.id.tv_titulo2)


            }
        }
}