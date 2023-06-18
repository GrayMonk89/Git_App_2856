package ru.graymonk.poplib.gitapp.mvp.model

import io.reactivex.rxjava3.core.Single

class GitHubUsersRepository {

    private val usersList = listOf(
        GitHubUser("Ellen Ripley"),
        GitHubUser("Dwayne Hicks"),
        GitHubUser("Ged"),
        GitHubUser("Meetra Surik"),
        GitHubUser("Rincewind the Wizzard"),
        GitHubUser("Corwin, a Prince of Amber"),
        GitHubUser("Sarah Connor")
    )

    fun getUsersList(): Single<List<GitHubUser>> {
        return Single.create {
            it.onSuccess(usersList)
        }
    }
}