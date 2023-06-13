package ru.graymonk.poplib.gitapp.mvp.presenter

import moxy.MvpPresenter
import ru.graymonk.poplib.gitapp.mvp.model.GitHubUser
import ru.graymonk.poplib.gitapp.mvp.model.GitHubUsersRepository
import ru.graymonk.poplib.gitapp.mvp.presenter.list.IUserListPresenter
import ru.graymonk.poplib.gitapp.mvp.view.MainView
import ru.graymonk.poplib.gitapp.mvp.view.list.UserItemView

class MainPresenter(private val usersRepository: GitHubUsersRepository) : MvpPresenter<MainView>() {
    val usersListPresenter = UsersListPresenter()

    class UsersListPresenter : IUserListPresenter {

        val users = mutableListOf<GitHubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)?
            get() = TODO("Not yet implemented")
            set(value) {}

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }

        override fun getCount() = users.size

    }


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

        loadData()

        usersListPresenter.itemClickListener = {

        }
    }

    fun loadData() {
        val users = usersRepository.getUsersList()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }
}