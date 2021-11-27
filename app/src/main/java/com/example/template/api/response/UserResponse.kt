package com.example.template.api.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("_id")
    val id: String,
    val name: String,
    val location: String,
    val age: String,
    val avatarUrl: String,
    val stats: UserStats,
    val rating: String,
    val email: String,
    val userType: String
)

data class UserStats(
    val running15: UserStatsValue,
    val running30: UserStatsValue,
    val running60: UserStatsValue,
    val stamina: UserStatsValue,
    val agility: UserStatsValue,
    val dribbling: UserStatsValue
)

data class UserStatsValue(
    val value: String,
    val videoUrl: String
)
