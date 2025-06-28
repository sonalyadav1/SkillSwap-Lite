package com.skillswap.lite.activities

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.skillswap.lite.R
import com.skillswap.lite.adapters.SkillsAdapter
import com.skillswap.lite.models.Skill
import com.skillswap.lite.utils.MockDataUtil

class ProfileActivity : AppCompatActivity() {
    
    private lateinit var ivProfile: ShapeableImageView
    private lateinit var tvUserName: TextView
    private lateinit var tvUserEmail: TextView
    private lateinit var rvMySkills: RecyclerView
    private lateinit var mySkillsAdapter: SkillsAdapter
    
    private val mySkillsList = mutableListOf<Skill>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        
        setupToolbar()
        initViews()
        setupRecyclerView()
        loadUserProfile()
        loadMySkills()
    }
    
    private fun setupToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = "My Profile"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    
    private fun initViews() {
        ivProfile = findViewById(R.id.iv_profile)
        tvUserName = findViewById(R.id.tv_user_name)
        tvUserEmail = findViewById(R.id.tv_user_email)
        rvMySkills = findViewById(R.id.rv_my_skills)
    }
    
    private fun setupRecyclerView() {
        mySkillsAdapter = SkillsAdapter(mySkillsList) { skill ->
            // Handle skill deletion or editing
            deleteSkill(skill)
        }
        rvMySkills.layoutManager = LinearLayoutManager(this)
        rvMySkills.adapter = mySkillsAdapter
    }
    
    private fun loadUserProfile() {
        // Using mock data for testing
        val user = MockDataUtil.mockCurrentUser
        tvUserName.text = user.name
        tvUserEmail.text = user.email
        
        // Set default profile image
        ivProfile.setImageResource(R.drawable.ic_profile_placeholder)
        
        /* Firebase version - uncomment when ready to use Firebase
        val user = FirebaseUtils.auth.currentUser
        user?.let {
            tvUserName.text = it.displayName ?: "Anonymous"
            tvUserEmail.text = it.email ?: ""
            
            if (it.photoUrl != null) {
                Glide.with(this)
                    .load(it.photoUrl)
                    .circleCrop()
                    .placeholder(R.drawable.ic_profile_placeholder)
                    .into(ivProfile)
            }
        }
        */
    }
    
    private fun loadMySkills() {
        // Using mock data for testing
        mySkillsList.clear()
        mySkillsList.addAll(MockDataUtil.getCurrentUserSkills())
        mySkillsAdapter.updateSkills(mySkillsList)
        
        /* Firebase version - uncomment when ready to use Firebase
        val currentUserId = FirebaseUtils.getCurrentUserId()
        if (currentUserId == null) {
            Toast.makeText(this, "Please sign in first", Toast.LENGTH_SHORT).show()
            return
        }
        
        FirebaseUtils.firestore.collection(FirebaseUtils.SKILLS_COLLECTION)
            .whereEqualTo("userId", currentUserId)
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Toast.makeText(this, "Error loading skills: ${error.message}", Toast.LENGTH_SHORT).show()
                    return@addSnapshotListener
                }
                
                mySkillsList.clear()
                snapshot?.documents?.forEach { document ->
                    val skill = document.toObject(Skill::class.java)?.copy(id = document.id)
                    skill?.let { mySkillsList.add(it) }
                }
                mySkillsAdapter.updateSkills(mySkillsList)
            }
        */
    }
    
    private fun deleteSkill(skill: Skill) {
        // Mock deletion for testing
        Toast.makeText(this, "Skill deleted successfully (Mock)", Toast.LENGTH_SHORT).show()
        
        /* Firebase version - uncomment when ready to use Firebase
        FirebaseUtils.firestore.collection(FirebaseUtils.SKILLS_COLLECTION)
            .document(skill.id)
            .delete()
            .addOnSuccessListener {
                Toast.makeText(this, "Skill deleted successfully", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error deleting skill: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        */
    }
    
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
