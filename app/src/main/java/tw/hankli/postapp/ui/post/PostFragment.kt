package tw.hankli.postapp.ui.post

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_post.*
import tw.hankli.postapp.App
import tw.hankli.postapp.R
import tw.hankli.postapp.ui.MainActivity

class PostFragment: Fragment(R.layout.fragment_post) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view_btn.setOnClickListener {
            App.signOut(requireContext()) {
                findNavController().navigate(PostFragmentDirections.actionGlobalAuthFragment())
            }
        }
    }

    override fun onStart() {
        super.onStart()

        App.auth.currentUser?.let {
            view_label.text = it.displayName
        }
    }
}