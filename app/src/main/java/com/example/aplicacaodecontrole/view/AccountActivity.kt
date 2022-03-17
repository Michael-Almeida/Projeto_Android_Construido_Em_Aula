package com.example.aplicacaodecontrole.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.aplicacaodecontrole.BusinessControllApplication
import com.example.aplicacaodecontrole.R
import com.example.aplicacaodecontrole.viewModel.AccountsViewModel
import com.example.aplicacaodecontrole.viewModel.ResponsableActivityViewModel
import com.example.aplicacaodecontrole.viewModel.ResponsableViewModelFactory

class AccountActivity : AppCompatActivity() {

    private val accountsViewModel: AccountsViewModel by viewModels() {
        ResponsableViewModelFactory(application as BusinessControllApplication)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
    }

    fun saveAccount(view: View) {
        accountsViewModel.saveAccout()
        finish()
    }
}