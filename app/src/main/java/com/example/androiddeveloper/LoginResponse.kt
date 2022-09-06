package com.example.androiddeveloper

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("rc")
    var rc: String,
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("rd")
    var rd: String
) {
    data class Data(
        @SerializedName("user")
        var user: String,
        @SerializedName("password")
        var password: String
    )
}