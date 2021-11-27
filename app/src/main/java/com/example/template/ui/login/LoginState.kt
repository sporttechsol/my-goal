package com.example.template.ui.login

sealed class LoginState {
    data class EnterEmail(
        val email: String,
        val emailInvalid: Boolean = false
    ): LoginState()
}
