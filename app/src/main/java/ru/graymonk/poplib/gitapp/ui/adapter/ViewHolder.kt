package ru.graymonk.poplib.gitapp.ui.adapter

import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.graymonk.poplib.gitapp.databinding.ItemUserBinding
import ru.graymonk.poplib.gitapp.mvp.view.IImageLoader
import ru.graymonk.poplib.gitapp.mvp.view.list.UserItemView
import ru.graymonk.poplib.gitapp.utils.AppConstants

class ViewHolder(private val viewBinding: ItemUserBinding, private val imageLoader: IImageLoader<ImageView>) :
    RecyclerView.ViewHolder(viewBinding.root), UserItemView {
    override fun setLogin(text: String) = with(viewBinding){
        itemUserTextViewLogin.text = text
    }

    override fun loadAvatar(url: String) = with(viewBinding){
        imageLoader.loadInto(url, viewBinding.itemUserImageViewAvatar)
    }

    override var pos: Int = AppConstants.DEFAULT_INVALID_INDEX
}