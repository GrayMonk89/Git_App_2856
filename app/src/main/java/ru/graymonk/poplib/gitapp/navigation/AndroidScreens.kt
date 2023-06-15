package ru.graymonk.poplib.gitapp.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.graymonk.poplib.gitapp.ui.fragments.UsersFragment

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen{ UsersFragment.newInstance()}
}