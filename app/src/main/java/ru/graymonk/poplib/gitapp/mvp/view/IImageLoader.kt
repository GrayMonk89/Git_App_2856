package ru.graymonk.poplib.gitapp.mvp.view

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}