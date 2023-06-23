package ru.graymonk.poplib.gitapp.mvp.model.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import ru.graymonk.poplib.gitapp.mvp.model.entity.GitHubUser

interface IDataSource {
    @GET("/users")
    fun getUsers() : Single<List<GitHubUser>>
}