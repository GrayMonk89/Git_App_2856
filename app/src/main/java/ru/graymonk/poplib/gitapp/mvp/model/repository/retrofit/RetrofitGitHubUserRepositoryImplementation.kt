package ru.graymonk.poplib.gitapp.mvp.model.repository.retrofit

import io.reactivex.rxjava3.schedulers.Schedulers
import ru.graymonk.poplib.gitapp.mvp.model.api.IDataSource
import ru.graymonk.poplib.gitapp.mvp.model.repository.IGitHubUsersRepository

class RetrofitGitHubUserRepositoryImplementation(private val api: IDataSource) :
    IGitHubUsersRepository {
    override fun getUsersList() = api.getUsers().subscribeOn(Schedulers.io())
}