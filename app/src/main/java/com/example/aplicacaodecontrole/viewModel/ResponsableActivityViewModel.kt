package com.example.aplicacaodecontrole.viewModel

import android.content.Context
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicacaodecontrole.Model.Responsible
import com.example.aplicacaodecontrole.R
import com.example.aplicacaodecontrole.infra.database.ResponsibleDAO
import com.example.aplicacaodecontrole.repository.ResponsibleRespository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import java.lang.reflect.Type

class ResponsableActivityViewModel(val responsibleRespository: ResponsibleRespository) : BaseViewModel() {

    @Bindable
    var name: String = ""

    fun saveResponsible()=viewModelScope.launch{
         val responsible = Responsible(name)

       responsibleRespository.save(responsible)
    }

//    private val gson: Gson = Gson()
//
//    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }
//
//    fun saveResponsible(context: Context) {
//
//        val sharedPref = context.getSharedPreferences(
//            context.getString(R.string.preference_list_responsibles), Context.MODE_PRIVATE
//        ) ?: return
//
//        val stringResponsibles =
//            sharedPref.getString(context.getString(R.string.preference_list_responsibles), "")
//
//        println(stringResponsibles)
//
//        val type: Type = object : TypeToken<List<Responsible>>() {}.type
//
//        val listResponsibles: MutableList<Responsible> =
//            if (stringResponsibles.isNullOrBlank()) mutableListOf()
//            else gson.fromJson(stringResponsibles, type)
//
//        val novoResponsavel = Responsible(name)
//        listResponsibles.add(novoResponsavel)
//
//        with(sharedPref.edit()) {
//            putString(
//                context.getString(R.string.preference_list_responsibles),
//                gson.toJson(listResponsibles)
//            )
//            commit()
//        }
//
//    }
}