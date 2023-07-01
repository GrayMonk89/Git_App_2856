package ru.graymonk.poplib.gitapp.mvp.model.repository

import io.reactivex.rxjava3.core.Single
import ru.graymonk.poplib.gitapp.mvp.model.entity.GitHubUser
import ru.graymonk.poplib.gitapp.mvp.model.entity.GitHubUserRepositories

interface IRetrofitGitHubUserRepositoriesRepository {
    fun getRepositories(user: GitHubUser): Single<List<GitHubUserRepositories>>
}