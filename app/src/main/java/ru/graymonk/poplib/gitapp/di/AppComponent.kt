package ru.graymonk.poplib.gitapp.di

import dagger.Component
import ru.graymonk.poplib.gitapp.di.module.ApiModule
import ru.graymonk.poplib.gitapp.di.module.AppModule
import ru.graymonk.poplib.gitapp.di.module.CacheModule
import ru.graymonk.poplib.gitapp.di.module.CiceroneModule
import ru.graymonk.poplib.gitapp.di.module.ImageLoaderModule
import ru.graymonk.poplib.gitapp.di.module.RepositoryModule
import ru.graymonk.poplib.gitapp.mvp.presenter.MainPresenter
import ru.graymonk.poplib.gitapp.mvp.presenter.UsersPresenter
import ru.graymonk.poplib.gitapp.ui.activity.MainActivity
import ru.graymonk.poplib.gitapp.ui.adapter.UsersRecyclerViewAdapter
import ru.graymonk.poplib.gitapp.ui.fragments.UsersFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        CacheModule::class,
        CiceroneModule::class,
        RepositoryModule::class,
        ImageLoaderModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(usersPresenter: UsersPresenter)
    fun inject(usersFragment: UsersFragment)
    //fun inject(userDetailsFragment: UserDetailsFragment)
    fun inject(usersRecyclerViewAdapter: UsersRecyclerViewAdapter)


}