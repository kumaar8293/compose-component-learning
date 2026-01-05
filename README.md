# Compose Learning Project

A comprehensive Android Jetpack Compose learning project that demonstrates various UI components, state management, and best practices.

## 📋 Table of Contents

- [Overview](#overview)
- [Getting Started](#getting-started)
- [How to Use This Project](#how-to-use-this-project)
- [Widgets Demo Guide](#widgets-demo-guide)
- [Project Structure](#project-structure)
- [Adding New Widgets](#adding-new-widgets)

## 🎯 Overview

This project is designed to help you learn Jetpack Compose by exploring different widgets and concepts. Each widget demonstrates specific Compose features and patterns.

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog or later
- Android SDK 24 or higher
- Kotlin 1.9.0 or higher

### Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd composelearning
   ```

2. Open the project in Android Studio

3. Sync Gradle files

4. Run the app on an emulator or physical device

## 📖 How to Use This Project

This project uses a single `MainActivity` with commented-out code blocks. To explore different widgets:

1. Open `app/src/main/java/com/example/compose_learning/MainActivity.kt`
2. Find the section you want to test (marked with comments like `//====== 0 ==========`)
3. Comment out the currently active section
4. Uncomment the section you want to test
5. Run the app to see the widget in action

## 🎨 Widgets Demo Guide

### Widget 0: Column with Scrollable Blog Categories

**Location:** Section `//====== 0 ==========`

**What it demonstrates:**
- Using `Column` with `verticalScroll` modifier
- Creating scrollable lists with `rememberScrollState()`
- Building reusable card components (`BlogCategory`)
- Displaying a list of items using `.map()`

**How to test:**
1. Uncomment lines 57-61 in `MainActivity.kt`
2. Comment out other active sections
3. Run the app

**Key Concepts:**
- `Modifier.verticalScroll(rememberScrollState())` - Makes Column scrollable
- `BlogCategory` composable - Reusable card component
- `getCategoryList()` - Generates 100 sample items

---

### Widget 1: LazyColumn for Efficient Lists

**Location:** Section `//====== 1 ==========`

**What it demonstrates:**
- Using `LazyColumn` for efficient list rendering
- Lazy loading of items (only visible items are composed)
- Better performance for large lists compared to regular Column

**How to test:**
1. Uncomment lines 64-68 in `MainActivity.kt`
2. Comment out other active sections
3. Run the app

**Key Concepts:**
- `LazyColumn` - Efficiently renders only visible items
- `items()` - DSL for adding items to LazyColumn
- Performance optimization for large datasets

---

### Widget 2: Recomposition Demo

**Location:** Section `//====== 2 ==========`

**What it demonstrates:**
- Understanding Compose recomposition
- How state changes trigger recomposition
- Using `remember` to preserve state across recompositions
- Logging recomposition behavior

**How to test:**
1. Uncomment lines 71-78 in `MainActivity.kt`
2. Comment out other active sections
3. Run the app and check Logcat for "LENSA" tag
4. Click the button to see recomposition logs

**Key Concepts:**
- `remember { mutableStateOf() }` - Preserves state across recompositions
- Recomposition - Re-execution of composables when state changes
- State hoisting principles

---

### Widget 3: Remember and RememberSaveable

**Location:** Section `//====== 3 ==========`

**What it demonstrates:**
- Difference between regular variable, `remember`, and `rememberSaveable`
- State persistence across configuration changes
- Three different counter implementations:
  - `NotificationCounter()` - Doesn't work (state lost on recomposition)
  - `NotificationCounterWithRemember()` - Works but loses state on rotation
  - `NotificationCounterWithRememberSaveable()` - Persists state across rotations

**How to test:**
1. Uncomment lines 82-88 in `MainActivity.kt`
2. Comment out other active sections
3. Run the app
4. Click buttons and rotate device to see state persistence differences

**Key Concepts:**
- `remember` - Preserves state during recomposition only
- `rememberSaveable` - Preserves state across configuration changes (rotation, etc.)
- State management best practices

---

### Widget 4: Hoisting and Unidirectional Data Flow

**Location:** Section `//====== 4 ==========`

**What it demonstrates:**
- State hoisting pattern
- Unidirectional data flow
- Sharing state between multiple composables
- Best practices for state management

**How to test:**
1. Uncomment lines 91-97 in `MainActivity.kt`
2. Comment out other active sections
3. Run the app
4. Click the button and observe how state is shared between components

**Key Concepts:**
- State hoisting - Moving state to a common ancestor
- Unidirectional data flow - State flows down, events flow up
- Reusable composables with parameters
- `MessageBar` component that reacts to shared state

---

### Widget 5: Expandable Card

**Location:** Section `//====== 5 ==========`

**What it demonstrates:**
- Animated expandable/collapsible card
- Material 3 `IconButton` usage
- Content size animations
- Icon rotation animations
- Customizable card component with multiple parameters

**How to test:**
1. Uncomment lines 101-115 in `MainActivity.kt`
2. Comment out other active sections
3. Run the app
4. Click the card or icon to expand/collapse

**Key Concepts:**
- `animateContentSize()` - Animates size changes
- `animateFloatAsState()` - Animates icon rotation
- `IconButton` - Material 3 clickable icon component
- Conditional composition with `if (expandedState.value)`

---

### Widget 6: Google Sign Up Button

**Location:** Section `//====== 6 ==========`

**What it demonstrates:**
- Custom button component with loading state
- Animated content size transitions
- Progress indicator integration
- Click handling with callbacks
- Material 3 `Surface` component

**Demo Video:**

Watch the demo: [Google Sign Up Button Demo](screenshot/google-sign-up.mp4)

> **Note:** Click the link above to view the video demonstration of Widget 6 in action, showing the button's loading state and smooth animations.

**How to test:**
1. Uncomment lines 118-127 in `MainActivity.kt` (already active)
2. Run the app
3. Click the button to see loading animation

**Key Concepts:**
- Custom composable with callback (`onClicked`)
- Loading state management
- `CircularProgressIndicator` - Material 3 loading indicator
- `Surface` with border and click handling
- Content size animation for smooth transitions

---

## 📁 Project Structure

```
app/src/main/java/com/example/compose_learning/
├── MainActivity.kt                    # Main activity with widget demos
├── dummy/ui/
│   ├── 0_Column.kt                   # Column and BlogCategory widget
│   ├── 1_LazyColumn.kt               # LazyColumn widget
│   ├── 2_Recompostion.kt             # Recomposition demo
│   ├── 3_RememberAndRememberSaveable.kt  # State management demo
│   ├── 4_HoistingAndUniDirectionalFlow.kt # State hoisting demo
│   ├── 05_ExpandedCard.kt            # Expandable card widget
│   └── 05_GoogleSignUpButton.kt      # Google button widget
└── ui/theme/
    ├── Color.kt                      # Color scheme definitions
    ├── Shape.kt                      # Shape definitions
    ├── Theme.kt                      # Theme configuration
    └── Type.kt                       # Typography definitions
```

## ➕ Adding New Widgets

To add a new widget to this project:

1. **Create a new widget file:**
   - Create a new `.kt` file in `app/src/main/java/com/example/compose_learning/dummy/ui/`
   - Name it descriptively (e.g., `6_MyNewWidget.kt`)

2. **Create your composable:**
   ```kotlin
   package com.example.compose_learning.dummy.ui
   
   import androidx.compose.runtime.Composable
   
   @Composable
   fun MyNewWidget() {
       // Your widget implementation
   }
   ```

3. **Add to MainActivity:**
   - Import your widget in `MainActivity.kt`
   - Add a new commented section:
   ```kotlin
   //====== 7 My New Widget ==========
   // Column(
   //     modifier = Modifier.fillMaxSize()
   // ) {
   //     MyNewWidget()
   // }
   ```

4. **Update this README:**
   - Add documentation for your new widget following the same format

5. **Add comments:**
   - Comment your code explaining key concepts
   - Use clear variable names
   - Document any complex logic

## 🎓 Learning Resources

- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Compose State Management](https://developer.android.com/jetpack/compose/state)
- [Material 3 Components](https://m3.material.io/)

## 📝 Notes

- Each widget is designed to be independent and can be tested separately
- Check Logcat for "LENSA" tag to see recomposition logs
- All widgets follow Material 3 design guidelines
- State management examples show best practices for Compose

## 🤝 Contributing

Feel free to add more widgets and examples! When adding new widgets:
- Follow the existing code structure
- Add comprehensive comments
- Update this README
- Test your widget thoroughly

---

**Happy Learning! 🚀**

