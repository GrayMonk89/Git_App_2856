package ru.graymonk.poplib.gitapp.mvp.model.repository

import io.reactivex.rxjava3.core.Single
import ru.graymonk.poplib.gitapp.mvp.model.entity.GitHubUser

interface IGitHubUsersRepository {
    fun getUsersList(): Single<List<GitHubUser>>
}