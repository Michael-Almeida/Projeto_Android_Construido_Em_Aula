package com.example.aplicacaodecontrole.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.aplicacaodecontrole.R
import com.example.aplicacaodecontrole.databinding.ActivityResponsibleBinding
import com.example.aplicacaodecontrole.viewModel.ResponsableActivityViewModel
import com.example.aplicacaodecontrole.viewModel.ResponsableViewModelFactory

class ResponsibleActivity: AppCompatActivity() {

    private val responsibleActivityViewModel: ResponsableActivityViewModel by lazy {
        ViewModelProvider(this, ResponsableViewModelFactory).get(ResponsableActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityResponsibleBinding = DataBindingUtil.setContentView(this, R.layout.activity_responsible)
        binding.viewmodel = responsibleActivityViewModel



    }

    fun salvarResponsavel(view: View){
        Toast.makeText(this,"${responsibleActivityViewModel.responsable} Adicionado com Sucesso ",
            Toast.LENGTH_LONG).show()
        finish()
    }
}