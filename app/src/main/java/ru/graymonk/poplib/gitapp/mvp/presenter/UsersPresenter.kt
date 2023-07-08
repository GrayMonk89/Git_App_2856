package ru.graymonk.poplib.gitapp.mvp.presenter

import android.annotation.SuppressLint
import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.graymonk.poplib.gitapp.mvp.model.entity.GitHubUser
import ru.graymonk.poplib.gitapp.mvp.model.repository.IGitHubUsersRepository
import ru.graymonk.poplib.gitapp.mvp.presenter.list.IUserListPresenter
import ru.graymonk.poplib.gitapp.mvp.view.UsersView
import ru.graymonk.poplib.gitapp.mvp.view.list.UserItemView
import ru.graymonk.poplib.gitapp.navigation.IScreens
import ru.graymonk.poplib.gitapp.ui.activity.BackButtonListener
import javax.inject.Inject

class UsersPresenter :
    MvpPresenter<UsersView>(), BackButtonListener {

    @Inject
     lateinit var uiSchedulers: Scheduler

    @Inject
     lateinit var usersRepository: IGitHubUsersRepository

    @Inject
     lateinit var router: Router

    @Inject
     lateinit var screens: IScreens

    val usersListPresenter = UsersListPresenter()

    class UsersListPresenter : IUserListPresenter {

        val users = mutableListOf<GitHubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            user.login.let() { view.setLogin(it) }
            user.avatarUrl?.let { view.loadAvatar(it) }
        }

        override fun getCount() = users.size

    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()

        loadData()

        usersListPresenter.itemClickListener = {
            router.navigateTo(screens.userDetails(usersListPresenter.users[it.pos]))
        }
    }


    @SuppressLint("CheckResult")
    private fun loadData() {
        usersRepository.getUsersList().observeOn(uiSchedulers).subscribe({ userList ->
            usersListPresenter.users.clear()
            usersListPresenter.users.addAll(userList)
            viewState.updateList()
            Log.d("@@@", "$userList")
        }, {})
    }

    override fun backPressed(): Boolean {
        router.exit()
        return true
    }
}