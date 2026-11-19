package com.example.recyclerviewtrial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val items: ArrayList<Item>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    /**
     * Responsabile per creare nuove view per gli Items della RecyclerView
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    /**
     * Responsabile per prendere i dati di un elemnto della lista e inserirli nel relativo view
     */
    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val item = items[position]
        holder.imageView.setImageResource(item.image)
        holder.title.text = item.title
        holder.description.text = item.description
    }

    /**
     * Responsabile per conoscere quanti elementi contiene la lista
     */
    override fun getItemCount(): Int {
        return items.size
    }

    class MyViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        /**
         * itemView = rappresenta la singola riga della RecyclerView
         */
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val title: TextView = itemView.findViewById(R.id.title_txt)
        val description: TextView = itemView.findViewById(R.id.description_text)
    }
}