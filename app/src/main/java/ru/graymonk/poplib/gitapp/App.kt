package ru.graymonk.poplib.gitapp

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val navigationHolder = cicerone.getNavigatorHolder()

    val router = cicerone.router
}