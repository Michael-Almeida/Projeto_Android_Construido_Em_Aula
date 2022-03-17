package com.example.aplicacaodecontrole.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.example.aplicacaodecontrole.R
import com.example.aplicacaodecontrole.view.adapter.MainSectionPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
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

        bottomNavigationMenu.setOnNavigationItemSelectedListener(this::onOptionsItemSelected)
    }

    override fun onResume() {
        super.onResume()

        bottomNavigationMenu.uncheckAllItems()
    }

    private fun BottomNavigationView.uncheckAllItems() {
        menu.setGroupCheckable(0, true, false)
        for (i in 0 until menu.size()) {
            menu.getItem(i).isChecked = false
        }
        menu.setGroupCheckable(0, true, true)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        Toast.makeText(applicationContext, "teste de Toast", Toast.LENGTH_LONG).show()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.new_responsible -> {
                val intent = Intent(applicationContext, ResponsableActivity::class.java)
                startActivity(intent)
                //adiciona a tela
                true
            }
            R.id.new_account -> {
                val intent = Intent(applicationContext, AccountActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.new_transaction -> true
            R.id.configurations -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /*
    fun showSnackBar(view: View) {
        Snackbar
            .make(view, "Deseja realmente sair?", Snackbar.LENGTH_INDEFINITE)
            .setAction("Sim") {
                finish()
            }.show()
    }
     */
}