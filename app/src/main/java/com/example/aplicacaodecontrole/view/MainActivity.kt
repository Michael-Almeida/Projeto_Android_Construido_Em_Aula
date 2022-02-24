package com.example.aplicacaodecontrole.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.aplicacaodecontrole.R
import com.example.aplicacaodecontrole.view.adapter.MainSectionPagerAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sectionPagerAdapter = MainSectionPagerAdapter(supportFragmentManager, lifecycle)
        pager.adapter = sectionPagerAdapter

        TabLayoutMediator(tabs, pager) { tab, position ->

            tab.text = when (position) {
                0 -> "Resumo"
                1 -> "Transações"
                2 -> "Contas"
                else -> "Not Foiund"
            }
        }.attach()
    }


    fun showSnackBar(view: View) {
        Snackbar
            .make(view, "Deseja realmente sair?", Snackbar.LENGTH_INDEFINITE)
            .setAction("Sim") {
                finish()
            }.show()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        Toast.makeText(applicationContext, "teste de Toast", Toast.LENGTH_LONG).show()

    }
}