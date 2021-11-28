package com.example.template.ui.home

import androidx.lifecycle.ViewModel
import com.example.template.core.UserService
import com.example.template.core.update
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userService: UserService
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState(isPlayer = userService.user?.userType == "player"))
    val state = _state.asStateFlow()
}
