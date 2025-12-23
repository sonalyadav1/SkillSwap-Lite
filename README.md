# SkillSwap Lite 

A peer-to-peer Android application for skill exchange built with Kotlin and Firebase.

##  Overview

SkillSwap Lite connects people who want to share their skills and learn from others. Users can post skills they can teach (e.g., "I teach Python programming") and browse skills offered by others to find learning opportunities.

## Features

### Core Features
- ** Authentication**: Google Sign-in using Firebase Auth
- ** Post Skills**: Create skill posts with title, description, and tags
- ** Browse Skills**: View all skills in a scrollable list with search capabilities
- ** User Profile**: Manage your posted skills and view your profile
- ** Contact System**: Connect with skill providers

### Technical Features
- Material Design 3 UI components
- Real-time updates using Firestore
- Offline support
- Image loading with Glide
- Responsive design for various screen sizes

##  Tech Stack

- **Language**: Kotlin
- **Platform**: Android (API 24+)
- **Architecture**: MVVM
- **Backend**: Firebase
  - Authentication (Google Sign-in)
  - Cloud Firestore (NoSQL database)
  - Storage (profile images)
  - Cloud Messaging (notifications - future feature)
- **UI**: Material Design Components
- **Image Loading**: Glide
- **Build System**: Gradle

## 📁 Project Structure

```
SkillSwap Lite/
├── app/
│   ├── src/main/java/com/skillswap/lite/
│   │   ├── activities/          # Activity classes
│   │   │   ├── MainActivity.kt
│   │   │   ├── AuthActivity.kt
│   │   │   ├── PostSkillActivity.kt
│   │   │   └── ProfileActivity.kt
│   │   ├── adapters/            # RecyclerView adapters
│   │   │   └── SkillsAdapter.kt
│   │   ├── models/              # Data models
│   │   │   ├── Skill.kt
│   │   │   └── User.kt
│   │   └── utils/               # Utility classes
│   │       └── FirebaseUtils.kt
│   ├── src/main/res/
│   │   ├── layout/              # XML layouts
│   │   ├── values/              # Colors, strings, themes
│   │   ├── drawable/            # Icons and images
│   │   └── menu/                # Menu resources
│   └── build.gradle             # App-level dependencies
├── build.gradle                 # Project-level configuration
└── README.md
```

## Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK (API 24+)
- Google account for Firebase setup
- Git

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/skillswap-lite.git
   cd skillswap-lite
   ```

2. **Firebase Setup**
   - Go to [Firebase Console](https://console.firebase.google.com/)
   - Create a new project
   - Add an Android app with package name: `com.skillswap.lite`
   - Download `google-services.json` and place it in `app/` directory
   - Enable Authentication with Google Sign-in
   - Create a Firestore database
   - Set up Firebase Storage

3. **Configure Google Sign-in**
   - In Firebase Console, go to Authentication > Sign-in method
   - Enable Google Sign-in
   - Add your SHA-1 certificate fingerprint
   - Update `default_web_client_id` in `strings.xml`

4. **Open in Android Studio**
   - Open the project in Android Studio
   - Sync project with Gradle files
   - Run the app on an emulator or device

### Firebase Security Rules

Add these rules to your Firestore database:

```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    // Users can read/write their own user document
    match /users/{userId} {
      allow read, write: if request.auth != null && request.auth.uid == userId;
    }
    
    // Skills can be read by anyone, but only created/updated by the owner
    match /skills/{skillId} {
      allow read: if request.auth != null;
      allow create: if request.auth != null && request.auth.uid == resource.data.userId;
      allow update, delete: if request.auth != null && request.auth.uid == resource.data.userId;
    }
  }
}
```

##  App Screenshots

### Main Screens
- **Authentication**: Google Sign-in screen
- **Skills Feed**: Browse all available skills
- **Post Skill**: Create a new skill post
- **Profile**: View and manage your skills

##  Key Components

### Data Models
- **Skill**: Represents a skill post with title, description, tags
- **User**: User profile information

### Activities
- **AuthActivity**: Handles Google Sign-in
- **MainActivity**: Main feed showing all skills
- **PostSkillActivity**: Form to create new skill posts
- **ProfileActivity**: User profile and skill management

### Firebase Integration
- Real-time data synchronization
- Secure authentication
- Cloud storage for profile images
- Offline support

##  Build Configuration

### Dependencies
```gradle
// Firebase
implementation platform('com.google.firebase:firebase-bom:32.7.0')
implementation 'com.google.firebase:firebase-auth-ktx'
implementation 'com.google.firebase:firebase-firestore-ktx'
implementation 'com.google.firebase:firebase-storage-ktx'

// Material Design
implementation 'com.google.android.material:material:1.10.0'

// Image Loading
implementation 'com.github.bumptech.glide:glide:4.16.0'
```

##  Future Enhancements

- [ ] **In-app Chat**: Real-time messaging between users
- [ ] **Skill Categories**: Organize skills by categories
- [ ] **Search & Filter**: Advanced search with tags and location
- [ ] **Rating System**: Rate and review skill exchanges
- [ ] **Push Notifications**: Notify users of new matches
- [ ] **Geolocation**: Find skills in your area
- [ ] **Profile Pictures**: Upload custom profile images
- [ ] **Skill Requests**: Post what you want to learn

##  Project Metrics

- **Minimum SDK**: API 24 (Android 7.0)
- **Target SDK**: API 34 (Android 14)
- **Language**: 100% Kotlin
- **Architecture**: MVVM with Repository pattern

##  Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

##  License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

##  Acknowledgments

- Material Design for UI components
- Firebase for backend services
- Glide for image loading
- The Android developer community

## 📞 Contact

**Sonal** - sonal.y6390@gmail.com

Project Link: [https://github.com/yourusername/skillswap-lite](https://github.com/yourusername/skillswap-lite)

---


