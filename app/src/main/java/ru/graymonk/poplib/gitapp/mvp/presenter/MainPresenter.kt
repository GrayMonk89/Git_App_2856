package ru.graymonk.poplib.gitapp.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.graymonk.poplib.gitapp.mvp.view.MainView
import ru.graymonk.poplib.gitapp.navigation.IScreens

class MainPresenter(private val router: Router, private val screens : IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked(){
        router.exit()
    }

}