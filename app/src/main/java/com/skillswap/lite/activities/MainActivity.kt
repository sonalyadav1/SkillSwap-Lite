package com.skillswap.lite.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.skillswap.lite.R
import com.skillswap.lite.adapters.SkillsAdapter
import com.skillswap.lite.models.Skill
import com.skillswap.lite.utils.MockDataUtil

class MainActivity : AppCompatActivity() {
    
    private lateinit var recyclerView: RecyclerView
    private lateinit var skillsAdapter: SkillsAdapter
    private lateinit var fab: FloatingActionButton
    private val skillsList = mutableListOf<Skill>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // For testing without Firebase - comment out authentication check
        /*
        if (!FirebaseUtils.isUserLoggedIn()) {
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
            return
        }
        */
        
        setContentView(R.layout.activity_main)
        
        setupToolbar()
        setupRecyclerView()
        setupFab()
        loadSkills()
    }
    
    private fun setupToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = "SkillSwap Lite"
    }
    
    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.rv_skills)
        skillsAdapter = SkillsAdapter(skillsList) { skill ->
            showContactInfo(skill)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = skillsAdapter
    }
    
    private fun setupFab() {
        fab = findViewById(R.id.fab_add_skill)
        fab.setOnClickListener {
            startActivity(Intent(this, PostSkillActivity::class.java))
        }
    }
    
    private fun loadSkills() {
        // Using mock data for testing without Firebase
        skillsList.clear()
        skillsList.addAll(MockDataUtil.mockSkills)
        skillsAdapter.updateSkills(skillsList)
        
        /* Firebase version - uncomment when ready to use Firebase
        FirebaseUtils.firestore.collection(FirebaseUtils.SKILLS_COLLECTION)
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    Toast.makeText(this, "Error loading skills: ${error.message}", Toast.LENGTH_SHORT).show()
                    return@addSnapshotListener
                }
                
                skillsList.clear()
                snapshot?.documents?.forEach { document ->
                    val skill = document.toObject(Skill::class.java)
                    skill?.let { skillsList.add(it) }
                }
                skillsAdapter.updateSkills(skillsList)
            }
        */
    }
    
    private fun showContactInfo(skill: Skill) {
        // Simple contact info display - in a real app, this could open a chat or show contact details
        Toast.makeText(
            this, 
            "Contact ${skill.userName} at ${skill.userEmail}", 
            Toast.LENGTH_LONG
        ).show()
    }
    
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_profile -> {
                startActivity(Intent(this, ProfileActivity::class.java))
                true
            }
            R.id.action_logout -> {
                // Mock logout - in real app this would sign out from Firebase
                Toast.makeText(this, "Logged out (Mock)", Toast.LENGTH_SHORT).show()
                // FirebaseUtils.auth.signOut()
                // startActivity(Intent(this, AuthActivity::class.java))
                // finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
