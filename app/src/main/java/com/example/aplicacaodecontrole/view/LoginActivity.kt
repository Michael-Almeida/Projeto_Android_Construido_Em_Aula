package com.example.aplicacaodecontrole.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.aplicacaodecontrole.R
import com.example.aplicacaodecontrole.databinding.ActivityLoginBinding
import com.example.aplicacaodecontrole.viewModel.LoginViewModel
import com.example.aplicacaodecontrole.viewModel.LoginViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {


    private val loginViewModel: LoginViewModel by lazy {
        ViewModelProvider(this, LoginViewModelFactory).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginBinding: ActivityLoginBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_login
        )
        loginBinding.viewModel = loginViewModel
        redirectToMainActivity()
//        loginViewModel.userLogin = "admin@admin.com"
//        loginViewModel.userPassword = "pass"
//        loginViewModel.doLogin()
    }

    fun redirectToMainActivity() {
        loginViewModel.redirect.observe(this) {
            if (it) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    //validação
    fun doLogin(view: View) {
        if (loginViewModel.formIsValid()) {
            loginViewModel.doLogin()
//
        } else {
            when {
                loginViewModel.userPassword.isBlank() -> passwordET.error =
                    getString(R.string.password_blank)
                loginViewModel.userLogin.isBlank() -> usernameET.error =
                    getString(R.string.email_blank)

                else -> usernameET.error = getString(R.string.email_invalid)
            }
        }

    }
}