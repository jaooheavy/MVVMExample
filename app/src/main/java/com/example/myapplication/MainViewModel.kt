package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.POJO.Address
import com.google.gson.Gson
import com.koushikdutta.async.kotlin.await
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainViewModel(application: Application) : AndroidViewModel(application) {

    //Inicializacao
    private val cep = MutableLiveData<Address>()
    init {
        cep.value = Address("Buscar CEP")
    }

    //Lista que tem conexão com o View
    fun getCharacters(): LiveData<Address> {
        return cep
    }

    //Metodo para carregar os dados async
    fun load(){
        CoroutineScope(Dispatchers.IO).launch {
            val res = CEPApi.loadCEP(this@MainViewModel.getApplication<Application>().applicationContext)?.await()
            val cep = Gson().fromJson(res, Address::class.java)

            withContext(Dispatchers.Main){
                this@MainViewModel.cep.value = cep
            }
        }
    }
}