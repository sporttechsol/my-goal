package com.example.template.ui.first

import androidx.lifecycle.ViewModel
import com.example.template.core.update
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(FirstState())
    val state = _state.asStateFlow()

    fun onNameChanged(name: String) {
        _state.update { it.copy(name = name) }
    }
}
