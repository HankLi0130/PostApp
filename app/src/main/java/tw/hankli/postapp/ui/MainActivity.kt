package tw.hankli.postapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import tw.hankli.postapp.App
import tw.hankli.postapp.MainNavDirections
import tw.hankli.postapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.view_nav_host)

        if (!App.hasUser()) {
            navController.navigate(MainNavDirections.actionGlobalAuthFragment())
        }
    }
}