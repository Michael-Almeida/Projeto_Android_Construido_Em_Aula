package com.example.aplicacaodecontrole.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.aplicacaodecontrole.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun isLoginOk() =
        usernameET.text.toString() == ("admin") && passwordET.text.toString() == ("pass")

    fun doLogin(view: View) {
        if (isLoginOk()) {

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(applicationContext, "Usuário ou senha inválida", Toast.LENGTH_LONG)
                .show()
        }

    }
}