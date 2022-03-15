package com.example.aplicacaodecontrole.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacaodecontrole.Model.Account
import com.example.aplicacaodecontrole.R

//viewHoder é o elemento que irá aparecer na tela
//dizer qual lista que irá receber, qual layout e qual é o maepamento dos itens da tela com o objeto account

class AccountAdapter(private val accountList: List<Account>) :
    RecyclerView.Adapter<AccountAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_account, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.accountName.text = accountList[position].name
    }

    override fun getItemCount(): Int = accountList.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val accountName: TextView = view.findViewById(R.id.account_name)
    }
}