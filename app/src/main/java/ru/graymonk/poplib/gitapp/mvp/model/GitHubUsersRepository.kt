package ru.graymonk.poplib.gitapp.mvp.model

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

    fun getUsersList() : List<GitHubUser>{
        return usersList
    }
}