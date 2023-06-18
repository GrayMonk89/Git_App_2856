package ru.graymonk.poplib.gitapp.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.graymonk.poplib.gitapp.mvp.model.GitHubUser
import ru.graymonk.poplib.gitapp.ui.fragments.UserDetailsFragment
import ru.graymonk.poplib.gitapp.ui.fragments.UsersFragment

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen{ UsersFragment.newInstance()}
    override fun userDetails(gitHubUser: GitHubUser) = FragmentScreen{ UserDetailsFragment.newInstance(gitHubUser)}
}