# SkillSwap Lite - GitHub Copilot Instructions

<!-- Use this file to provide workspace-specific custom instructions to Copilot. For more details, visit https://code.visualstudio.com/docs/copilot/copilot-customization#_use-a-githubcopilotinstructionsmd-file -->

## Project Overview
SkillSwap Lite is an Android application built with Kotlin that allows users to exchange skills in a peer-to-peer manner. Users can post skills they can teach and browse skills offered by others.

## Tech Stack
- **Language**: Kotlin
- **Platform**: Android (API 24+)
- **Architecture**: MVVM with Repository pattern
- **Backend**: Firebase
  - Firebase Authentication (Google Sign-in)
  - Cloud Firestore (database)
  - Firebase Storage (profile images)
  - Firebase Cloud Messaging (notifications)
- **UI**: Material Design Components
- **Image Loading**: Glide

## Project Structure
```
app/src/main/java/com/skillswap/lite/
├── activities/          # Activity classes
├── fragments/           # Fragment classes  
├── models/             # Data models
├── adapters/           # RecyclerView adapters
└── utils/              # Utility classes
```

## Key Features
1. **Authentication**: Google Sign-in using Firebase Auth
2. **Post Skills**: Users can create skill posts with title, description, and tags
3. **Browse Skills**: RecyclerView displaying all skills with search/filter
4. **User Profile**: View and manage posted skills
5. **Contact System**: Basic contact information sharing

## Coding Guidelines
- Follow Material Design principles
- Use ViewBinding for layout interactions
- Implement proper error handling with user-friendly messages
- Use Firebase Firestore for real-time data updates
- Follow Android architecture best practices
- Use proper resource management (strings, colors, dimensions)

## Firebase Integration
- Ensure all Firebase operations include proper error handling
- Use Firestore real-time listeners for live updates
- Implement offline support where possible
- Keep user data synchronized between Authentication and Firestore

## UI/UX Considerations
- Material Design 3 components
- Responsive layouts for different screen sizes
- Loading states and empty states
- Accessibility support
- Consistent color scheme and typography
