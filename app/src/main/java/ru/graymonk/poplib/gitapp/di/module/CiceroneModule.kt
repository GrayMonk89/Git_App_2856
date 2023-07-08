package ru.graymonk.poplib.gitapp.di.module

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import ru.graymonk.poplib.gitapp.navigation.AndroidScreens
import ru.graymonk.poplib.gitapp.navigation.IScreens
import javax.inject.Singleton

@Module
class CiceroneModule {
    var cicerone: Cicerone<Router> = Cicerone.create()


    @Provides
    fun cicerone(): Cicerone<Router> = cicerone

    @Singleton
    @Provides
    fun navigationHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

    @Singleton
    @Provides
    fun router(): Router = cicerone.router

    @Singleton
    @Provides
    fun androidScreens(): IScreens = AndroidScreens()
}