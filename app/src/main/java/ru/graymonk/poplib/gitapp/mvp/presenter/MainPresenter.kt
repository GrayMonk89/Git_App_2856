package ru.graymonk.poplib.gitapp.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.graymonk.poplib.gitapp.mvp.view.MainView
import ru.graymonk.poplib.gitapp.navigation.IScreens
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>() {


    @Inject
     lateinit var router: Router

    @Inject
     lateinit var screens: IScreens
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }
    /*32.40*/
}