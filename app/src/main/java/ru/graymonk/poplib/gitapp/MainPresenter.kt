package ru.graymonk.poplib.gitapp

import moxy.MvpPresenter
import ru.graymonk.poplib.gitapp.utils.Constants

class MainPresenter(private val countersModel: CountersModel) : MvpPresenter<MainView>() {

    fun counterOneClick() {

        viewState.setCounterOneText(
            countersModel.setNextValue(Constants.DEFAULT_VALUE_ZERO).toString()
        )

    }

    fun counterTwoClick() {

        viewState.setCounterTwoText(
            countersModel.setNextValue(Constants.DEFAULT_VALUE_ONE ).toString()
        )

    }

    fun counterThreeClick() {

        viewState.setCounterThreeText(
            countersModel.setNextValue(Constants.DEFAULT_VALUE_TWO).toString()
        )

    }
}