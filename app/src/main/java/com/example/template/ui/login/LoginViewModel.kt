package com.example.template.ui.login

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.template.api.MyGoalApi
import com.example.template.core.UserService
import com.example.template.core.update
import com.example.template.navigation.NavigationRoute
import com.example.template.ui.home.HomeNavigationRoute
import com.example.template.ui.login.LoginState.EnterEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val api: MyGoalApi,
    private val userService: UserService,
) : ViewModel() {
    private val _state = MutableStateFlow<LoginState>(EnterEmail(email = ""))
    val state = _state.asStateFlow()

    fun onEmailChanged(email: String) {
        _state.update { (it as EnterEmail).copy(email = email, emailInvalid = false) }
    }

    fun onLoginButtonClick(navController: NavController) {
        viewModelScope.launch {
            try {
                val user = api.getUser(email = (state.value as EnterEmail).email)
                userService.user = user
                navController.navigate(NavigationRoute.HomeScreen.name)
//                _state.value = LoginState.LoginSuccess
            } catch (e: HttpException) {
                _state.update { (it as EnterEmail).copy(emailInvalid = true) }
            }
        }
    }
}
