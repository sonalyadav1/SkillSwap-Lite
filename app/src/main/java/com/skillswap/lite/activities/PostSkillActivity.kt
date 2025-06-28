package com.skillswap.lite.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.skillswap.lite.R
import com.skillswap.lite.models.Skill
import com.skillswap.lite.utils.MockDataUtil

class PostSkillActivity : AppCompatActivity() {
    
    private lateinit var etTitle: EditText
    private lateinit var etDescription: EditText
    private lateinit var etTags: EditText
    private lateinit var chipGroupTags: ChipGroup
    private lateinit var btnAddTag: Button
    private lateinit var btnPostSkill: Button
    
    private val tags = mutableListOf<String>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_skill)
        
        setupToolbar()
        initViews()
        setupClickListeners()
    }
    
    private fun setupToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = "Post a Skill"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    
    private fun initViews() {
        etTitle = findViewById(R.id.et_skill_title)
        etDescription = findViewById(R.id.et_skill_description)
        etTags = findViewById(R.id.et_tag_input)
        chipGroupTags = findViewById(R.id.chip_group_tags)
        btnAddTag = findViewById(R.id.btn_add_tag)
        btnPostSkill = findViewById(R.id.btn_post_skill)
    }
    
    private fun setupClickListeners() {
        btnAddTag.setOnClickListener {
            addTag()
        }
        
        btnPostSkill.setOnClickListener {
            postSkill()
        }
    }
    
    private fun addTag() {
        val tagText = etTags.text.toString().trim()
        if (tagText.isNotEmpty() && !tags.contains(tagText)) {
            tags.add(tagText)
            
            val chip = Chip(this)
            chip.text = tagText
            chip.isCloseIconVisible = true
            chip.setOnCloseIconClickListener {
                tags.remove(tagText)
                chipGroupTags.removeView(chip)
            }
            
            chipGroupTags.addView(chip)
            etTags.text.clear()
        }
    }
    
    private fun postSkill() {
        val title = etTitle.text.toString().trim()
        val description = etDescription.text.toString().trim()
        
        if (title.isEmpty()) {
            etTitle.error = "Title is required"
            return
        }
        
        if (description.isEmpty()) {
            etDescription.error = "Description is required"
            return
        }
        
        // Using mock data for testing
        val skill = Skill(
            id = "skill_${System.currentTimeMillis()}",
            userId = MockDataUtil.mockCurrentUser.uid,
            userName = MockDataUtil.mockCurrentUser.name,
            userEmail = MockDataUtil.mockCurrentUser.email,
            title = title,
            description = description,
            tags = tags.toList(),
            timestamp = System.currentTimeMillis(),
            profileImageUrl = MockDataUtil.mockCurrentUser.profileImageUrl
        )
        
        // Simulate successful posting
        Toast.makeText(this, "Skill posted successfully! (Mock)", Toast.LENGTH_SHORT).show()
        finish()
        
        /* Firebase version - uncomment when ready to use Firebase
        val user = FirebaseUtils.auth.currentUser
        if (user == null) {
            Toast.makeText(this, "Please sign in first", Toast.LENGTH_SHORT).show()
            return
        }
        
        val skill = Skill(
            id = "", // Firestore will generate this
            userId = user.uid,
            userName = user.displayName ?: "Anonymous",
            userEmail = user.email ?: "",
            title = title,
            description = description,
            tags = tags.toList(),
            timestamp = System.currentTimeMillis(),
            profileImageUrl = user.photoUrl?.toString() ?: ""
        )
        
        FirebaseUtils.firestore.collection(FirebaseUtils.SKILLS_COLLECTION)
            .add(skill)
            .addOnSuccessListener {
                Toast.makeText(this, "Skill posted successfully!", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this, "Error posting skill: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        */
    }
    
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
