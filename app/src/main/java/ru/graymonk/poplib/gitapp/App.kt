package ru.graymonk.poplib.gitapp

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import ru.graymonk.poplib.gitapp.mvp.model.entity.room.DataBase
import ru.graymonk.poplib.gitapp.mvp.model.network.INetworkStatus
import ru.graymonk.poplib.gitapp.navigation.AndroidScreens
import ru.graymonk.poplib.gitapp.ui.network.AndroidNetworkStatus

class App : Application() {
    companion object {
        lateinit var instance: App
        lateinit var networkStatus: INetworkStatus
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        networkStatus = AndroidNetworkStatus(instance)
        DataBase.createDataBase(this)
    }

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val navigationHolder = cicerone.getNavigatorHolder()

    val router = cicerone.router

    val androidScreens = AndroidScreens()
}