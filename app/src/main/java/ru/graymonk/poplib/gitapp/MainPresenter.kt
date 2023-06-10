package ru.graymonk.poplib.gitapp

class MainPresenter(private val view: MainView) {

    private val countersModel: CountersModel = CountersModel()

    fun counterClick(id: Int) {
        when (id) {
            R.id.mainActivityButtonCounterOne -> {
                val value = countersModel.setNextValue(0).toString()
                view.setCounterText(0, value)
            }

            R.id.mainActivityButtonCounterTwo -> {
                view.setCounterText(1, countersModel.setNextValue(1).toString())

            }

            R.id.mainActivityButtonCounterThree -> {
                view.setCounterText(2, countersModel.setNextValue(2).toString())

            }
        }

    }
}