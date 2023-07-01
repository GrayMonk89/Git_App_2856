package ru.graymonk.poplib.gitapp.mvp.model.repository.retrofit

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.graymonk.poplib.gitapp.mvp.model.api.IDataSource
import ru.graymonk.poplib.gitapp.mvp.model.entity.GitHubUser
import ru.graymonk.poplib.gitapp.mvp.model.entity.room.DataBase
import ru.graymonk.poplib.gitapp.mvp.model.entity.room.RoomGitHubUser
import ru.graymonk.poplib.gitapp.mvp.model.network.INetworkStatus
import ru.graymonk.poplib.gitapp.mvp.model.repository.IGitHubUsersRepository

class RetrofitGitHubUserRepositoryImplementation(
    private val api: IDataSource,
    private val networkStatus: INetworkStatus,
    private val dataBase: DataBase
) :
    IGitHubUsersRepository {

    override fun getUsersList() = networkStatus.isOnlineSingle().flatMap { isOnline ->
        if (isOnline) {
            api.getUsers().flatMap { users ->
                Single.fromCallable {
                    val roomUsers = users.map { user ->
                        RoomGitHubUser(
                            user.id ?: "",
                            user.login ?: "",
                            user.avatarUrl ?: "",
                            user.reposeUrl ?: ""
                        )
                    }
                    dataBase.userDao.insert(roomUsers)
                    users
                }
            }
        } else {
            Single.fromCallable {
                dataBase.userDao.getAll().map { roomUser ->
                    GitHubUser(
                        roomUser.id,
                        roomUser.login,
                        roomUser.avatarUrl,
                        roomUser.reposeUrl
                    )
                }
            }
        }
    }.subscribeOn(Schedulers.io())
    //override fun getUsersList() = api.getUsers().subscribeOn(Schedulers.io())
}