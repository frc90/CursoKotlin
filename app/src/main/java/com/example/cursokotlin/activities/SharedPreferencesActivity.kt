package com.example.cursokotlin.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cursokotlin.R
import kotlinx.android.synthetic.main.activity_main3.*

class SharedPreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        showData()
        btn_save.setOnClickListener {
            saveData()
            showData()
            toast("Los datos se han guardado!!!")
        }
        btn_delete.setOnClickListener {
            deleteData()
            showData()
            toast("Se borraron los datos!!!")
        }

        btn_login.setOnClickListener {
            if (cb_save.isChecked){
                saveData()
                toast("Se iniciara seccion!!!")

            }
        }
    }

    // mostrar los datos gurdados
    private fun showData(){
        val sharePref = getPreferences(Context.MODE_PRIVATE)
        val user = sharePref.getString("userName","")
        val pass = sharePref.getString("userPass","")
        et_user.setText(user)
        et_password.setText(pass)
    }

    // salvar los datos en modo privado
    private fun saveData(){
        val sharePref = getPreferences(Context.MODE_PRIVATE)
        with(sharePref.edit()){
            putString("userName", et_user.text.toString())
            putString("userPass", et_password.text.toString())
            commit()
        }
    }

    // borrar los datos
    private fun deleteData(){
        val sharePref = getPreferences(Context.MODE_PRIVATE)
        with(sharePref.edit()){
            putString("userName", "")
            putString("userPass", "")
            commit()
        }
    }

    private fun toast(text: String){
        return Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }


}