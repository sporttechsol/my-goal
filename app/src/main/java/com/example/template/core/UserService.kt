package com.example.template.core

import com.example.template.api.response.UserResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserService @Inject constructor() {
    var user: UserResponse? = null
}
