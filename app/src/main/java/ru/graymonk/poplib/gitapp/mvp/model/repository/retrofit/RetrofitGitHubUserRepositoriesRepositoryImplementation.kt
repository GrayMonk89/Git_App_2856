package ru.graymonk.poplib.gitapp.mvp.model.repository.retrofit

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.graymonk.poplib.gitapp.mvp.model.api.IDataSource
import ru.graymonk.poplib.gitapp.mvp.model.entity.GitHubUser
import ru.graymonk.poplib.gitapp.mvp.model.entity.GitHubUserRepositories
import ru.graymonk.poplib.gitapp.mvp.model.entity.room.DataBase
import ru.graymonk.poplib.gitapp.mvp.model.entity.room.RoomGitHubRepository
import ru.graymonk.poplib.gitapp.mvp.model.network.INetworkStatus
import ru.graymonk.poplib.gitapp.mvp.model.repository.IRetrofitGitHubUserRepositoriesRepository

class RetrofitGitHubUserRepositoriesRepositoryImplementation(
    private val api: IDataSource,
    private val networkStatus: INetworkStatus,
    private val dataBase: DataBase
) : IRetrofitGitHubUserRepositoriesRepository {

    override fun getRepositories(user: GitHubUser) =
        networkStatus.isOnlineSingle().flatMap { isOnline ->
            if (isOnline) {
                user.reposeUrl?.let { url ->
                    api.getRepositories(url).flatMap { repository -> /*  1.06.42  */
                        Single.fromCallable {
                            val roomUser = user.login.let {
                                dataBase.userDao.findByLogin(it)
                            } ?: throw java.lang.RuntimeException("No such user in cache")

                            val roomRepository = repository.map {
                                RoomGitHubRepository(
                                    it.id,
                                    it.name ?: "",
                                    it.forksCount ?: 0,
                                    roomUser.id
                                )
                            }
                            dataBase.repositoryDao.insert(roomRepository)
                            repository
                        }
                    }
                }
                    ?: Single.error<List<GitHubUserRepositories>>(RuntimeException("No such user in cache"))
                        .subscribeOn(
                            Schedulers.io()
                        )
            } else {
                Single.fromCallable {
                    val roomUser = user.login.let { dataBase.userDao.findByLogin(it) }
                        ?: throw RuntimeException("No such user in cache")
                    dataBase.repositoryDao.findForUser(roomUser.id).map {
                        GitHubUserRepositories(it.id, it.name, it.forksCount)
                    }
                }

            }
        }
}