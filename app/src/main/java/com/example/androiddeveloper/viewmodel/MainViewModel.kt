package com.example.androiddeveloper.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddeveloper.model.MainRepository
import com.example.androiddeveloper.model.dataMenu
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {
    val movieList = MutableLiveData<ArrayList<dataMenu>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMenu() {
        val response = repository.getAllMenu()
        response.enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val key = response.body()!!.keySet()
                val arrayData = arrayListOf<dataMenu>()
                key.forEach {
                    val valueArray = response.body()!!.get(it).asJsonArray
                    valueArray.forEach { value ->
                        arrayData.add(dataMenu(it, value))
                    }
                }

                movieList.postValue(arrayData)
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}