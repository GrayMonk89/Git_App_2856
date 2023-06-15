package ru.graymonk.poplib.gitapp.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.graymonk.poplib.gitapp.mvp.model.GitHubUser
import ru.graymonk.poplib.gitapp.mvp.model.GitHubUsersRepository
import ru.graymonk.poplib.gitapp.mvp.presenter.list.IUserListPresenter
import ru.graymonk.poplib.gitapp.mvp.view.UsersView
import ru.graymonk.poplib.gitapp.mvp.view.list.UserItemView
import ru.graymonk.poplib.gitapp.ui.activity.BackButtonListener

class UsersPresenter(private val usersRepository: GitHubUsersRepository, private val router: Router) :
    MvpPresenter<UsersView>(), BackButtonListener {

    val usersListPresenter = UsersListPresenter()

    class UsersListPresenter : IUserListPresenter {

        val users = mutableListOf<GitHubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

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

    private fun loadData() {
        val users = usersRepository.getUsersList()
        usersListPresenter.users.addAll(users)
        viewState.updateList()
    }

    override fun backPressed() : Boolean{
        router.exit()
        return true
    }
}