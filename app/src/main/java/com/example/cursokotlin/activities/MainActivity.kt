package com.example.cursokotlin.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cursokotlin.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_action.setOnClickListener {
            tv_text.setText(etxt_text.text)
        }

        btn_switch.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        btn_shared.setOnClickListener {
            val intent = Intent(this, SharedPreferencesActivity::class.java)
            startActivity(intent)
        }

        btn_retrofit.setOnClickListener {
            val intent = Intent(this, RetrofitActivity::class.java)
            startActivity(intent)
        }

//        val owner: Owner = Owner("gastsail", "Gaston Saillen")
//        val owner2 = Owner2("lucasnobile")
//        val owner3 = Owner("gastsail", "Gaston Saillen")
//        val owner4 = Owner2()
//
//        if (owner == owner3) {
//            // owner.hashCode() == owner3.hashCode()
//            // true
//        }
//
//        if (owner === owner3){
//            // false
//        }else {
//            //true
//        }
//
//
//        saludar("Francisco")
    }

    fun saludar(nombre: String):String{
        return "Hola $nombre"
    }
}