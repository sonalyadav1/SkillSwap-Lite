package com.skillswap.lite.utils

import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

/**
 * Extension functions and utility methods
 */

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Long.toFormattedDate(): String {
    val formatter = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
    return formatter.format(Date(this))
}

fun String.isValidEmail(): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

object Constants {
    const val SKILLS_PER_PAGE = 20
    const val IMAGE_PICK_REQUEST = 1001
    const val CAMERA_REQUEST = 1002
    
    // Skill categories for future use
    val SKILL_CATEGORIES = listOf(
        "Technology",
        "Design",
        "Music",
        "Languages",
        "Sports",
        "Cooking",
        "Art",
        "Business",
        "Photography",
        "Other"
    )
}
