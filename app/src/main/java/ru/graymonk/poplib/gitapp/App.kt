package ru.graymonk.poplib.gitapp

import android.app.Application
import ru.graymonk.poplib.gitapp.di.AppComponent
import ru.graymonk.poplib.gitapp.di.DaggerAppComponent
import ru.graymonk.poplib.gitapp.di.module.AppModule

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent
        private set
    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

}