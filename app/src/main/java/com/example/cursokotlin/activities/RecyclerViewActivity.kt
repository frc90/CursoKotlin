package com.example.cursokotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cursokotlin.R
import com.example.cursokotlin.adapters.NamesAdapter
import kotlinx.android.synthetic.main.activity_main2.*

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //
        recyclerView.layoutManager = LinearLayoutManager(this)

        // intanciando la clase para crear el adaptador
        recyclerView.adapter = NamesAdapter()

        // obteniendo la lista del string.xml
        val list = resources.getStringArray(R.array.names)

        // pasandole la lista al recyclerView.adapter llamandolo como NamesAdapter
        (recyclerView.adapter as NamesAdapter).setListNames(list.asList())

        et_filter.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("filter", p0.toString())

                val filteredList = list.filter { it.toString().toLowerCase().contains(p0.toString().toLowerCase()) }

                (recyclerView.adapter as NamesAdapter).setListNames(filteredList)
            }
        })
    }
}