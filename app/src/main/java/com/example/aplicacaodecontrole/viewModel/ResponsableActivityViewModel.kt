package com.example.aplicacaodecontrole.viewModel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel

class ResponsableActivityViewModel : ViewModel(), Observable {

    @Bindable
    var responsable: String = ""

    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

   override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

   override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }
}