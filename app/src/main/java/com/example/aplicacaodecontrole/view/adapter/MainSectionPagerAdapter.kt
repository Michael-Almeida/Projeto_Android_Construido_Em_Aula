package com.example.aplicacaodecontrole.view.adapter


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.aplicacaodecontrole.view.fragment.AccountsFragment
import com.example.aplicacaodecontrole.view.fragment.ResumeFragment
import com.example.aplicacaodecontrole.view.fragment.TransactionsFragment

class MainSectionPagerAdapter(fm: FragmentManager, private val lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> createFragmentWithSectionNumber(ResumeFragment(),position)
            1 -> createFragmentWithSectionNumber(ResumeFragment(),position)
            2 -> createFragmentWithSectionNumber(ResumeFragment(), position)
            else -> throw IllegalAccessException("Posição desconhecida")
        }
    }

    //criando seção de fragmentos com seção de números
    private fun createFragmentWithSectionNumber(fragment: Fragment, position: Int): Fragment {
        return fragment.apply {
            arguments = Bundle().apply {
                putInt(ResumeFragment.ARG_SECTION_NUMBER, position)
            }
        }
    }
}