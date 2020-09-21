package com.example.cursokotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cursokotlin.R
import kotlinx.android.synthetic.main.list_item.view.*

class NamesAdapter: RecyclerView.Adapter<NamesAdapter.NamesViewHolder>() {

    // se creo el view holder para inflar la vista(esto es por defecto)
    class NamesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    // funcion para llenar la lista con los nombres
    fun setListNames(list: List<String>){
        listOfNames = list
    }

    // inicializar la lista que recives
    private var listOfNames: List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesViewHolder {
        return NamesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return listOfNames.size
    }

    override fun onBindViewHolder(holder: NamesViewHolder, position: Int) {
        holder.itemView.tv_idText.text = position.toString()
        holder.itemView.tv_nameText.text = listOfNames[position]
    }
}