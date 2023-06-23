package ru.graymonk.poplib.gitapp.mvp.model.entity

import io.reactivex.rxjava3.core.Single
import ru.graymonk.poplib.gitapp.mvp.model.repository.IGitHubUsersRepository

class FakeGitHubUsersRepositoryImplementation : IGitHubUsersRepository {

    private val usersList = listOf(
        GitHubUser("0", "Ellen Ripley"),
        GitHubUser("1", "Dwayne Hicks"),
        GitHubUser("2", "Ged"),
        GitHubUser("3", "Meetra Surik"),
        GitHubUser("4", "Rincewind the Wizzard"),
        GitHubUser("5", "Corwin, a Prince of Amber"),
        GitHubUser("6", "Sarah Connor")
    )

    override fun getUsersList(): Single<List<GitHubUser>> {
        return Single.create {
            it.onSuccess(usersList)
        }
    }
}