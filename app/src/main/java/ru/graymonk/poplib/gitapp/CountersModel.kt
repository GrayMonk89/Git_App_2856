package ru.graymonk.poplib.gitapp

class CountersModel {

    private val countersValue = mutableListOf(0, 0, 0)

    fun getCounterValue(position: Int) = countersValue[position]

    fun setNextValue(position: Int) = ++countersValue[position]

    fun setValue(position: Int, value: Int) {
        countersValue[position] = value
    }
}