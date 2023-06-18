package ru.graymonk.poplib.gitapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.graymonk.poplib.gitapp.databinding.ItemUserBinding
import ru.graymonk.poplib.gitapp.mvp.view.list.UserItemView
import ru.graymonk.poplib.gitapp.utils.AppConstants

class ViewHolder(private val viewBinding: ItemUserBinding) :
    RecyclerView.ViewHolder(viewBinding.root), UserItemView {
    override fun setLogin(text: String) = with(viewBinding){
        tvLogin.text = text
    }
    override var pos: Int = AppConstants.DEFAULT_INVALID_INDEX
}