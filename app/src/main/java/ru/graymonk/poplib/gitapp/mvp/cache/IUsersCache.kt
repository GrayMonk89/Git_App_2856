package ru.graymonk.poplib.gitapp.mvp.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.graymonk.poplib.gitapp.mvp.model.entity.GitHubUser

interface IUsersCache {
    fun addUsersToDataBase(gitHubUsers : List<GitHubUser>): Completable
    fun getUsersFromDataBase(): Single<List<GitHubUser>>
}