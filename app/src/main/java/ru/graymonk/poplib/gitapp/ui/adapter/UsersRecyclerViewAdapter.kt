package ru.graymonk.poplib.gitapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.graymonk.poplib.gitapp.databinding.ItemUserBinding
import ru.graymonk.poplib.gitapp.mvp.presenter.list.IUserListPresenter
import ru.graymonk.poplib.gitapp.mvp.view.IImageLoader
import ru.graymonk.poplib.gitapp.mvp.view.list.UserItemView
import ru.graymonk.poplib.gitapp.utils.AppConstants
import javax.inject.Inject

class UsersRecyclerViewAdapter(private val presenter: IUserListPresenter) :
    RecyclerView.Adapter<UsersRecyclerViewAdapter.ViewHolder>() {

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemUserBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    ).apply {
        itemView.setOnClickListener {
            presenter.itemClickListener?.invoke(this)
        }
    }


    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply {
            pos = position
        })

    inner class ViewHolder(private val viewBinding: ItemUserBinding) :
        RecyclerView.ViewHolder(viewBinding.root), UserItemView {


        override fun setLogin(text: String) = with(viewBinding) {
            itemUserTextViewLogin.text = text
        }

        override fun loadAvatar(url: String) = with(viewBinding) {
            imageLoader.loadInto(url, itemUserImageViewAvatar)
        }

        override var pos: Int = AppConstants.DEFAULT_INVALID_INDEX
    }
}