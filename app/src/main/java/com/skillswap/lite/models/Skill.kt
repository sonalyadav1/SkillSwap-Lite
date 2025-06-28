package com.skillswap.lite.models

data class Skill(
    val id: String = "",
    val userId: String = "",
    val userName: String = "",
    val userEmail: String = "",
    val title: String = "",
    val description: String = "",
    val tags: List<String> = emptyList(),
    val timestamp: Long = System.currentTimeMillis(),
    val profileImageUrl: String = ""
) {
    // No-argument constructor for Firebase
    constructor() : this("", "", "", "", "", "", emptyList(), 0L, "")
}
