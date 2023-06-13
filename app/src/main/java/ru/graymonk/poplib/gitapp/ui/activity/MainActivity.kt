package ru.graymonk.poplib.gitapp.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.graymonk.poplib.gitapp.databinding.ActivityMainBinding
import ru.graymonk.poplib.gitapp.mvp.model.GitHubUsersRepository
import ru.graymonk.poplib.gitapp.mvp.presenter.MainPresenter
import ru.graymonk.poplib.gitapp.mvp.view.MainView
import ru.graymonk.poplib.gitapp.ui.adapter.UsersRecyclerViewAdapter


class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private val presenter by moxyPresenter { MainPresenter(GitHubUsersRepository()) }

    private lateinit var adapter: UsersRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun init() {
        binding.mainActivityUsersRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UsersRecyclerViewAdapter(presenter.usersListPresenter)
        binding.mainActivityUsersRecyclerView.adapter = adapter
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()

    }


}