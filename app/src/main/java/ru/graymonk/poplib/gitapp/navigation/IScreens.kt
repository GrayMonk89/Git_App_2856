package ru.graymonk.poplib.gitapp.navigation

import com.github.terrakok.cicerone.Screen
import ru.graymonk.poplib.gitapp.mvp.model.GitHubUser

interface IScreens {
    fun users() : Screen
    fun userDetails(gitHubUser: GitHubUser) : Screen
}