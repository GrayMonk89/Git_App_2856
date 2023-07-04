package ru.graymonk.poplib.gitapp.mvp.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.graymonk.poplib.gitapp.mvp.model.entity.GitHubUser
import ru.graymonk.poplib.gitapp.mvp.model.entity.room.DataBase
import ru.graymonk.poplib.gitapp.mvp.model.entity.room.RoomGitHubUser

class UsersCacheImplementation(private val dataBase: DataBase) : IUsersCache {
    override fun addUsersToDataBase(gitHubUsers: List<GitHubUser>): Completable {
        return dataBase.userDao.insert(gitHubUsers.map { user ->
            RoomGitHubUser(
                user.id,
                user.login,
                user.avatarUrl,
                user.reposeUrl
            )
        })
    }

    override fun getUsersFromDataBase(): Single<List<GitHubUser>> {
        return dataBase.userDao.getAll().map {
            it.map { roomGitHubUser ->
                GitHubUser(roomGitHubUser.id,
                    roomGitHubUser.login,
                    roomGitHubUser.avatarUrl,
                    roomGitHubUser.reposeUrl)
            }
        }
    }
}