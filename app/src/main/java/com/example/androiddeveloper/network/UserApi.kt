package com.example.androiddeveloper.network

import com.example.androiddeveloper.LoginRequest
import com.example.androiddeveloper.LoginResponse
import com.example.androiddeveloper.model.dataMenu
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {
    @POST("web/test_programmer.php")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    //Menu
    @GET("web/test_programmer.php")
    fun getAllMenu() : Call<JsonObject>

    companion object {
        fun getApi(): UserApi? {
            return ApiClient.client?.create(UserApi::class.java)
        }
    }
}