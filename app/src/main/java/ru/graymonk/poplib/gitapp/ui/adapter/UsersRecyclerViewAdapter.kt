package ru.graymonk.poplib.gitapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.graymonk.poplib.gitapp.databinding.ItemUserBinding
import ru.graymonk.poplib.gitapp.mvp.presenter.list.IUserListPresenter
import ru.graymonk.poplib.gitapp.ui.image.GlideImageLoader

class UsersRecyclerViewAdapter(private val presenter: IUserListPresenter) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(ItemUserBinding.inflate(
        LayoutInflater.from(parent.context), parent, false), GlideImageLoader()).apply {
            itemView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
    }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = presenter.bindView(holder.apply {
        pos = position
    })
}