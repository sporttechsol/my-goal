package com.example.template.core

import kotlinx.coroutines.flow.MutableStateFlow

fun <T> MutableStateFlow<T>.update(action: (T) -> T) {
    while (true) {
        val current = value
        val updated = action(current)
        if (compareAndSet(current, updated)) {
            break
        }
    }
}
