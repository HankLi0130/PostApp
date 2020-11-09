package tw.hankli.postapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import tw.hankli.postapp.App
import tw.hankli.postapp.MainNavDirections
import tw.hankli.postapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.view_nav_host)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            // Action Bar
            if (destination.id == R.id.authFragment) {
                supportActionBar?.hide()
            } else {
                supportActionBar?.show()
            }
        }
    }

    override fun onStart() {
        super.onStart()

        if (!App.hasUser()) {
            navController.navigate(MainNavDirections.actionGlobalAuthFragment())
        }
    }
}