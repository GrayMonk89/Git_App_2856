package ru.graymonk.poplib.gitapp.mvp.model.repository.retrofit

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.graymonk.poplib.gitapp.mvp.cache.UsersCacheImplementation
import ru.graymonk.poplib.gitapp.mvp.model.api.IDataSource
import ru.graymonk.poplib.gitapp.mvp.model.network.INetworkStatus
import ru.graymonk.poplib.gitapp.mvp.model.repository.IGitHubUsersRepository

class RetrofitGitHubUserRepositoryImplementation(
    private val api: IDataSource,
    private val networkStatus: INetworkStatus,
    private val cache: UsersCacheImplementation
) : IGitHubUsersRepository {

    override fun getUsersList() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            api.getUsers().flatMap { users ->
                cache.addUsersToDataBase(users).andThen(Single.just(users))
            }
        } else {
            cache.getUsersFromDataBase()
        }
    }.subscribeOn(Schedulers.io())
    //override fun getUsersList() = api.getUsers().subscribeOn(Schedulers.io())
}