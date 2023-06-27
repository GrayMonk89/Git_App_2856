package ru.graymonk.poplib.gitapp.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import coil.load
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.graymonk.poplib.gitapp.App
import ru.graymonk.poplib.gitapp.databinding.FragmentUserDiteailsBinding
import ru.graymonk.poplib.gitapp.mvp.model.entity.GitHubUser
import ru.graymonk.poplib.gitapp.mvp.presenter.UserDetailsPresenter
import ru.graymonk.poplib.gitapp.mvp.view.UserDetailsView
import ru.graymonk.poplib.gitapp.ui.activity.BackButtonListener

private const val ARG_CURRENT_USER = "Current user"

class UserDetailsFragment : MvpAppCompatFragment(), UserDetailsView, BackButtonListener {

    private var _binding: FragmentUserDiteailsBinding? = null
    private val binding: FragmentUserDiteailsBinding get() = _binding!!

    private var user: GitHubUser? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            if (it != null) {
                user = it.getParcelable(ARG_CURRENT_USER, GitHubUser::class.java)
            }
        }
    }

    private val presenter: UserDetailsPresenter by moxyPresenter {
        UserDetailsPresenter(App.instance.router)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserDiteailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(gitHubUser: GitHubUser) = UserDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_CURRENT_USER, gitHubUser)
            }
        }
    }

    override fun backPressed() = presenter.backPressed()

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun showDetails() {
        binding.userDetailFragmentTextViewLogin.text = user?.login
        binding.userDetailFragmentTextViewId.text = user?.id
        binding.userDetailFragmentImageViewAvatar.load(user?.avatarUrl)
        binding.userDetailFragmentTextViewRepository.text = user?.reposeUrl
    }
}