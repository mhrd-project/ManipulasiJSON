package com.example.androiddeveloper

import com.example.androiddeveloper.network.UserApi
import retrofit2.Response

class UserRepository {
    suspend fun loginUser(loginRequest:LoginRequest): Response<LoginResponse>? {
        return  UserApi.getApi()?.loginUser(loginRequest = loginRequest)
    }
}