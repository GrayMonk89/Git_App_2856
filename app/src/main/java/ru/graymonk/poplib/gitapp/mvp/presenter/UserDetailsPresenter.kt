package ru.graymonk.poplib.gitapp.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.graymonk.poplib.gitapp.mvp.view.UserDetailsView
import ru.graymonk.poplib.gitapp.ui.activity.BackButtonListener
import javax.inject.Inject

class UserDetailsPresenter() : MvpPresenter<UserDetailsView>(),
    BackButtonListener {

    @Inject
     lateinit var router: Router
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showDetails()
    }

    override fun backPressed(): Boolean {
        router.exit()
        return true
    }
}