package com.example.aplicacaodecontrole.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.aplicacaodecontrole.BusinessControllApplication
import com.example.aplicacaodecontrole.R
import com.example.aplicacaodecontrole.databinding.ActivityResponsibleBinding
import com.example.aplicacaodecontrole.viewModel.ResponsableActivityViewModel
import com.example.aplicacaodecontrole.viewModel.ResponsableViewModelFactory

class ResponsableActivity : AppCompatActivity() {

    private val responsibleActivityViewModel: ResponsableActivityViewModel by viewModels() {
       ResponsableViewModelFactory(application as BusinessControllApplication)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityResponsibleBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_responsible)
        binding.viewmodel = responsibleActivityViewModel

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    fun save(view: View) {
        responsibleActivityViewModel.saveResponsible()
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}