package com.example.androiddeveloper.view

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NO_HISTORY
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.androiddeveloper.BaseResponse
import com.example.androiddeveloper.LoginResponse
import com.example.androiddeveloper.viewmodel.LoginViewModel
import com.example.androiddeveloper.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel.loginResult.observe(this) {
            when (it) {
                is BaseResponse.Loading -> {
                    showLoading()
                }
                is BaseResponse.Success -> {
                    stopLoading()
                    processLogin(it.data)
                }
                is BaseResponse.Error -> {
                    processError(it.msg)
                }
                else -> {
                    stopLoading()
                }
            }
        }
        btn_login.setOnClickListener {
            doLogin()
        }
    }

    private fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(FLAG_ACTIVITY_NO_HISTORY)
        startActivity(intent)
    }

    fun doLogin() {
        val user = txtInput_email.text.toString()
        val password = txt_pass.text.toString()
        viewModel.loginUser(user = user, password = password)
    }

    fun showLoading() {
        prgbar.visibility = View.VISIBLE
    }

    fun stopLoading() {
        prgbar.visibility = View.GONE
    }

    fun processLogin(data: LoginResponse?) {
        if (data!!.rd == "Sukses") {
            Toast.makeText(this, ("rd:" + data.rd), Toast.LENGTH_SHORT).show()
            navigateToHome()
        } else {
            Toast.makeText(this, ("rd:" + data.rd), Toast.LENGTH_SHORT).show()
        }
    }

    fun processError(msg: String?) {
        Toast.makeText(this, ("Error:" + msg), Toast.LENGTH_SHORT).show()
    }
}