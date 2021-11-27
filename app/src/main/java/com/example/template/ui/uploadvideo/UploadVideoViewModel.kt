package com.example.template.ui.uploadvideo

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class UploadVideoViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(UploadVideoState(videoUrl = ""))
    val state = _state.asStateFlow()

    fun setVideoUrl(videoUrl: String) {
        _state.update { it.copy(videoUrl = videoUrl) }
    }
}
