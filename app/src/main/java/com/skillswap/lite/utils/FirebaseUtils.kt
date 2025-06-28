package com.skillswap.lite.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

object FirebaseUtils {
    val auth: FirebaseAuth = FirebaseAuth.getInstance()
    val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    val storage: FirebaseStorage = FirebaseStorage.getInstance()
    
    const val SKILLS_COLLECTION = "skills"
    const val USERS_COLLECTION = "users"
    
    fun getCurrentUserId(): String? = auth.currentUser?.uid
    
    fun isUserLoggedIn(): Boolean = auth.currentUser != null
}
