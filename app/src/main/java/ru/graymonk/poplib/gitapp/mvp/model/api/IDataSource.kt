package ru.graymonk.poplib.gitapp.mvp.model.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url
import ru.graymonk.poplib.gitapp.mvp.model.entity.GitHubUser
import ru.graymonk.poplib.gitapp.mvp.model.entity.GitHubUserRepositories

interface IDataSource {
    @GET("/users")
    fun getUsers() : Single<List<GitHubUser>>

    @GET
    fun getRepositories(@Url url: String): Single<List<GitHubUserRepositories>>
}