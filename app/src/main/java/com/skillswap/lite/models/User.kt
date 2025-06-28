package com.skillswap.lite.models

data class User(
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val profileImageUrl: String = "",
    val skills: List<String> = emptyList(),
    val joinedAt: Long = System.currentTimeMillis()
) {
    // No-argument constructor for Firebase
    constructor() : this("", "", "", "", emptyList(), 0L)
}
