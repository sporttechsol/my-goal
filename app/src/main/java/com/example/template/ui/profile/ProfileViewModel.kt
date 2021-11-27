package com.example.template.ui.profile

import androidx.lifecycle.ViewModel
import com.example.template.core.UserService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userService: UserService
) : ViewModel() {

    private val _state = MutableStateFlow(ProfileState(userService.user!!))
    val state = _state.asStateFlow()

}
