package tw.hankli.postapp.ui.auth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import tw.hankli.postapp.R

class AuthFragment : Fragment(R.layout.fragment_auth) {

    companion object {
        private const val REQUEST_SIGN_IN = 100
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed(
            Runnable { showAuthUI() },
            1000L
        )
    }

    private fun showAuthUI() {
        val idpConfigs = listOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.FacebookBuilder().build()
        )

        val intent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(idpConfigs)
            .build()

        startActivityForResult(intent, REQUEST_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                // Sign in successful.
                findNavController().navigate(AuthFragmentDirections.actionAuthFragmentToPostFragment())
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.

                if (response != null) {
                    response.error?.printStackTrace()
                }
                requireActivity().finish()
            }
        }
    }
}