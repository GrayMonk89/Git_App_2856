package ru.graymonk.poplib.gitapp.mvp.presenter.list

import ru.graymonk.poplib.gitapp.mvp.view.list.IItemView

interface IListPresenter<V : IItemView> {

    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}