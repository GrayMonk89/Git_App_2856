package ru.graymonk.poplib.gitapp

import ru.graymonk.poplib.gitapp.utils.Constants

class MainPresenter(private val view: MainView) {

    private val countersModel: CountersModel = CountersModel()

    fun counterClick(id: Int) {
        when (id) {
            Constants.DEFAULT_VALUE_ZERO -> {
                view.setCounterText(
                    Constants.DEFAULT_VALUE_ZERO,
                    countersModel.setNextValue(0).toString()
                )
            }

            Constants.DEFAULT_VALUE_ONE -> {
                view.setCounterText(
                    Constants.DEFAULT_VALUE_ONE,
                    countersModel.setNextValue(1).toString()
                )
            }

            Constants.DEFAULT_VALUE_TWO -> {
                view.setCounterText(
                    Constants.DEFAULT_VALUE_TWO,
                    countersModel.setNextValue(2).toString()
                )
            }
        }
    }
}