package com.skillswap.lite.utils

import com.skillswap.lite.models.Skill
import com.skillswap.lite.models.User

/**
 * Mock data for testing the app without Firebase
 */
object MockDataUtil {
    
    // Mock current user
    val mockCurrentUser = User(
        uid = "mock_user_123",
        name = "John Doe",
        email = "john.doe@example.com",
        profileImageUrl = "",
        skills = listOf("Python Programming", "Web Design"),
        joinedAt = System.currentTimeMillis() - 86400000 // 1 day ago
    )
    
    // Mock skills data
    val mockSkills = listOf(
        Skill(
            id = "skill_1",
            userId = "user_1",
            userName = "Alice Johnson",
            userEmail = "alice@example.com",
            title = "I teach Python Programming",
            description = "I have 5 years of experience in Python development. I can help you learn from basics to advanced concepts including web frameworks like Django and Flask.",
            tags = listOf("Python", "Programming", "Web Development", "Django"),
            timestamp = System.currentTimeMillis() - 3600000, // 1 hour ago
            profileImageUrl = ""
        ),
        Skill(
            id = "skill_2",
            userId = "user_2", 
            userName = "Bob Smith",
            userEmail = "bob@example.com",
            title = "Graphic Design & Adobe Creative Suite",
            description = "Professional graphic designer with 7+ years experience. I can teach Photoshop, Illustrator, and design principles.",
            tags = listOf("Design", "Photoshop", "Illustrator", "Creative"),
            timestamp = System.currentTimeMillis() - 7200000, // 2 hours ago
            profileImageUrl = ""
        ),
        Skill(
            id = "skill_3",
            userId = "user_3",
            userName = "Carol Wilson",
            userEmail = "carol@example.com", 
            title = "Spanish Language Tutoring",
            description = "Native Spanish speaker offering conversational practice and grammar lessons for all levels.",
            tags = listOf("Spanish", "Language", "Tutoring", "Conversation"),
            timestamp = System.currentTimeMillis() - 10800000, // 3 hours ago
            profileImageUrl = ""
        ),
        Skill(
            id = "skill_4",
            userId = "user_4",
            userName = "David Lee",
            userEmail = "david@example.com",
            title = "Guitar Lessons for Beginners",
            description = "Learn to play guitar! I offer lessons for complete beginners. We'll start with basic chords and progress to playing songs.",
            tags = listOf("Music", "Guitar", "Lessons", "Beginner"),
            timestamp = System.currentTimeMillis() - 14400000, // 4 hours ago
            profileImageUrl = ""
        ),
        Skill(
            id = "skill_5",
            userId = "user_5",
            userName = "Emma Davis",
            userEmail = "emma@example.com",
            title = "Digital Marketing & Social Media",
            description = "Learn how to grow your online presence! I'll teach you SEO, social media marketing, and content creation strategies.",
            tags = listOf("Marketing", "Social Media", "SEO", "Business"),
            timestamp = System.currentTimeMillis() - 18000000, // 5 hours ago
            profileImageUrl = ""
        ),
        Skill(
            id = "skill_6",
            userId = "mock_user_123", // Current user's skill
            userName = "John Doe",
            userEmail = "john.doe@example.com",
            title = "Web Development with React",
            description = "I can help you learn React.js, including hooks, state management, and building responsive web applications.",
            tags = listOf("React", "JavaScript", "Web Development", "Frontend"),
            timestamp = System.currentTimeMillis() - 21600000, // 6 hours ago
            profileImageUrl = ""
        )
    )
    
    // Mock user's own skills
    fun getCurrentUserSkills(): List<Skill> {
        return mockSkills.filter { it.userId == mockCurrentUser.uid }
    }
    
    // Add a new skill to mock data
    fun addSkill(skill: Skill): List<Skill> {
        return mockSkills.toMutableList().apply {
            add(0, skill.copy(
                id = "skill_${System.currentTimeMillis()}",
                userId = mockCurrentUser.uid,
                userName = mockCurrentUser.name,
                userEmail = mockCurrentUser.email,
                timestamp = System.currentTimeMillis()
            ))
        }
    }
}
