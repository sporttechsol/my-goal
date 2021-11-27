package com.example.template.api

import com.example.template.api.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MyGoalApi {
    @GET("user/{email}")
    suspend fun getUser(
        @Path("email") email: String
    ): UserResponse
}
