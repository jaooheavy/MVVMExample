package com.example.myapplication

import android.app.Application
import android.content.Context
import com.google.gson.JsonObject
import com.koushikdutta.ion.Ion
import com.koushikdutta.ion.future.ResponseFuture

object CEPApi {
    suspend fun loadCEP(context: Context): ResponseFuture<JsonObject>?{
       return Ion.with(context).load("https://viacep.com.br/ws/01001000/json/").asJsonObject().await();
    }
}
