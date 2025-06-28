# Testing SkillSwap Lite Without Firebase

## 🚀 Quick Start (No Firebase Required)

The app is now configured to work with **mock data** so you can test it immediately without setting up Firebase!

### What's Already Working:

✅ **Browse Skills**: See 6 pre-loaded skill examples  
✅ **Post Skills**: Add new skills (simulated)  
✅ **User Profile**: View mock user profile and skills  
✅ **Material Design UI**: Full UI with cards, chips, and navigation  
✅ **Navigation**: All screens and activities work  

### How to Run:

1. **Open in Android Studio**
2. **Sync Gradle** (Firebase dependencies are commented out)
3. **Run the app** - it will work immediately!

### Mock Data Included:

- **6 Sample Skills**: Python, Design, Spanish, Guitar, Marketing, React
- **Mock User**: John Doe with sample profile
- **Realistic Content**: Tags, descriptions, timestamps

### Testing Features:

1. **Main Screen**: Browse the skills feed
2. **Add Skill**: Tap the + button to post a new skill
3. **Profile**: Menu → Profile to see your skills
4. **Contact**: Tap "Contact" on any skill

## 🔄 Switching to Firebase Later

When you're ready to use Firebase:

1. **Uncomment Firebase code** in all activities
2. **Uncomment Google Services plugin** in build.gradle
3. **Add google-services.json** file
4. **Enable Firebase services** in console

### Files with Firebase Code:
- `MainActivity.kt` - Firestore listeners
- `PostSkillActivity.kt` - Skill posting
- `ProfileActivity.kt` - User profile loading
- `AuthActivity.kt` - Google Sign-in

All Firebase code is preserved in comments, so you can easily switch back!

## 📱 What You'll See:

- **Skills Feed**: Cards showing different skills
- **Material Design**: Modern UI with proper colors and typography
- **Working Navigation**: FAB, menu, toolbar
- **Responsive Layout**: Works on different screen sizes

Perfect for testing, screenshots, and demonstrating the app functionality!
