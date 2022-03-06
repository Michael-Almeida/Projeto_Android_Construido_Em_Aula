package com.example.aplicacaodecontrole.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplicacaodecontrole.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Picasso.get()
            .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbGHM8jf1drzKNAtzFYdPGjX6-hS3ojvulNA&usqp=CAU")
            .into(imageView)


        //chamar para dar uma parada antes de chamar a próxima tela
        GlobalScope.launch {
            delay(5000)


            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)

            finish()
        }
    }
}

