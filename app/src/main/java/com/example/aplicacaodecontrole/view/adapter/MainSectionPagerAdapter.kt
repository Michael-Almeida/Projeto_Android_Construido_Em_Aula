package com.example.aplicacaodecontrole.view.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.aplicacaodecontrole.view.fragment.AccountsFragment
import com.example.aplicacaodecontrole.view.fragment.ResumeFragment
import com.example.aplicacaodecontrole.view.fragment.TransactionsFragment

class MainSectionPagerAdapter (fm: FragmentManager, private val lifecycle: Lifecycle) : FragmentStateAdapter (fm, lifecycle){

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ResumeFragment()
            1 -> TransactionsFragment()
            2 -> AccountsFragment()
            else -> throw IllegalAccessException("POsição desconhecida")
        }
    }
}