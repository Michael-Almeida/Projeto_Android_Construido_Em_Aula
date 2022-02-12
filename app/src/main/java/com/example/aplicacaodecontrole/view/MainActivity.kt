package com.example.aplicacaodecontrole.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.aplicacaodecontrole.R
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      val toast =  Toast.makeText(applicationContext, "Olá Mundo", Toast.LENGTH_LONG)

        //show é para desparar
        toast.show()
    }

    fun showSnackBar(view : View){

        Snackbar.make(view, "Deseja realmente sair?", Snackbar.LENGTH_INDEFINITE)

            .setAction("Sim"){
                finish()
            }.show()
    }
}