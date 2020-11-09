# PostApp

An Android social media app using Android Jetpack and Firebase

## Step by step with Hank

1. Create a project called Post App

2. Import Navigation Component into the project
> - [Java 8 language feature support (Android Gradle Plugin 3.0.0+)](https://developer.android.com/studio/write/java8-support#supported_features)
> - [Set up your environment](https://developer.android.com/guide/navigation/navigation-getting-started#Set-up)
> - [Use Safe Args to pass data with type safety](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args)

- Others
>- [Kotlin Classes and Inheritance](https://kotlinlang.org/docs/reference/classes.html)

3. Create a Firebase project
> - Firebase was originally an independent company founded in 2011. In 2014, Google acquired the platform.
> - [Add Firebase to your Android project](https://youtu.be/EmFA1l3ZGC0)

4. Import FirebaseUI Auth
> - [GitHub firebase/FirebaseUI-Android](https://github.com/firebase/FirebaseUI-Android)

5. Let's do an auth flow. First of all, we need functions to help us to handle users, create an `App` and add relevant functions using FirebaseUI.

6. Check the user in `onStart()` in MainActivity, if the user doesn't exist navigate to the AuthFragment.

7. Create a button in AuthFragment, after click the button, it'll call FirebaseUI Auth to help the user to sign in (include sign up). Right now, we need to setup Providers.
> - [Sign in](https://firebase.google.com/docs/auth/android/firebaseui#sign_in)
> - [Identity provider configuration](https://github.com/firebase/FirebaseUI-Android/blob/master/auth/README.md#identity-provider-configuration)

8. Configure Facebook Provider

- Facebook Developer
> 1. Create a new project on Facebook Developer website.
> 2. Setup Facebook login app.
> 3. Settings -> Basic -> get App ID, App Secret.

- Firebase Console
> 1. Setup App ID, App Secret.
> 2. Assign the OAuth redirect URL to the Facebook App.

- Android Studio
> 1. Setup `facebook_application_id` and `facebook_login_protocol_scheme` in strings.xml.
> 2. Coding IdpConfig and others in AuthFragment.


