package tw.hankli.postapp

import android.app.Application
import android.content.Context
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

class App : Application() {

    companion object {
        val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

        fun hasUser(): Boolean = auth.currentUser != null

        fun signOut(context: Context, onComplete: () -> Unit) {
            AuthUI.getInstance()
                .signOut(context)
                .addOnCompleteListener { onComplete() }
        }
    }
}