package com.example.androiddeveloper.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddeveloper.model.MainRepository
import com.example.androiddeveloper.model.dataMenu
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {
    val movieList = MutableLiveData<List<dataMenu>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllMenu() {
        val response = repository.getAllMenu()
        response.enqueue(object : Callback<List<dataMenu>> {
            override fun onResponse(call: Call<List<dataMenu>>, response: Response<List<dataMenu>>) {
                movieList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<dataMenu>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}