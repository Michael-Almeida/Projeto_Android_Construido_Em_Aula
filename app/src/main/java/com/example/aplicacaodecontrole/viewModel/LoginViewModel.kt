package com.example.aplicacaodecontrole.viewModel

import android.util.Patterns
import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicacaodecontrole.Model.Result
import com.example.aplicacaodecontrole.Model.Login
import com.example.aplicacaodecontrole.Model.User
import com.example.aplicacaodecontrole.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//lateinit = inicia a variável depois

class LoginViewModel(val repository: LoginRepository) : ViewModel(), Observable {
    @Bindable
    var userLogin: String = ""

    @Bindable
    var userPassword: String = ""

    @Bindable
    var loadVisibility: Int = View.GONE
        set(value) {
            field = value
            notifyPropertyChange(BR.loadVisibility)
        }

    @Bindable
    var errorMessage: String = ""
        set(value) {
            field = value
            notifyPropertyChange(BR.errorMessage)
        }
    private val callbacks: PropertyChangeRegistry by lazy {
        PropertyChangeRegistry()
    }

    val redirect: MutableLiveData<Boolean> = MutableLiveData(false)


    fun notifyPropertyChange(fieldId: Int) {
        callbacks.notifyCallbacks(this, fieldId, null)
    }

    fun formIsValid() =
        this.userLogin.isNotBlank() && this.userPassword.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(
            this.userLogin
        ).matches()

    fun doLogin() {
        this.loadVisibility = View.VISIBLE

        viewModelScope.launch(Dispatchers.IO) {

            var result = repository.login(userLogin, userPassword)
            when (result){
                is Result.Sucess<User> -> redirect.postValue(true)
                is Result.Error -> showError(result.exception.message)
            }

            loadVisibility = View.GONE
        }
    }

    private fun showError(message: String?) {
        this.errorMessage = message ?: "Erro desconhecido"

    }

    //através destes dois métodos a aplicação irá se comunicar entre a variável do código e a
    //aplicação da tela
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }
}