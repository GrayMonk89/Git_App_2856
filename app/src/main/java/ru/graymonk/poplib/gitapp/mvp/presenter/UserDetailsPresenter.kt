package ru.graymonk.poplib.gitapp.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.graymonk.poplib.gitapp.mvp.view.UserDetailsView
import ru.graymonk.poplib.gitapp.ui.activity.BackButtonListener

class UserDetailsPresenter(private val router: Router) : MvpPresenter<UserDetailsView>(),
    BackButtonListener {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showDetails()
    }

    override fun backPressed(): Boolean {
        router.exit()
        return true
    }
}