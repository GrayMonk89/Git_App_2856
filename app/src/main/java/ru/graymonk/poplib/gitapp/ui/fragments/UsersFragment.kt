package ru.graymonk.poplib.gitapp.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.graymonk.poplib.gitapp.App
import ru.graymonk.poplib.gitapp.databinding.FragmentUsersBinding
import ru.graymonk.poplib.gitapp.mvp.model.GitHubUsersRepository
import ru.graymonk.poplib.gitapp.mvp.presenter.UsersPresenter
import ru.graymonk.poplib.gitapp.mvp.view.UsersView
import ru.graymonk.poplib.gitapp.ui.activity.BackButtonListener
import ru.graymonk.poplib.gitapp.ui.adapter.UsersRecyclerViewAdapter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {

    private var _binding: FragmentUsersBinding? = null
    private val binding: FragmentUsersBinding get() = _binding!!

    private val presenter by moxyPresenter {
        UsersPresenter(
            GitHubUsersRepository(),
            App.instance.router
        )
    }

    private lateinit var adapter: UsersRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = UsersFragment()
    }

    override fun init() {
        binding.usersFragmentRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = UsersRecyclerViewAdapter(presenter.usersListPresenter)
        binding.usersFragmentRecyclerView.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}