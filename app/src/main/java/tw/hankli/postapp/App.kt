package tw.hankli.postapp

import android.app.Application
import com.google.firebase.auth.FirebaseAuth

class App : Application() {

    companion object {
        val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

        fun hasUser(): Boolean = auth.currentUser != null
    }
}