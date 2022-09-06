package com.example.androiddeveloper.model

import com.example.androiddeveloper.network.UserApi

class MainRepository constructor(private val retrofitService: UserApi) {
    fun getAllMenu() = retrofitService.getAllMenu()
}