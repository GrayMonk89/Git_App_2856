package ru.graymonk.poplib.gitapp.ui.image

import android.widget.ImageView
import com.bumptech.glide.Glide
import ru.graymonk.poplib.gitapp.mvp.view.IImageLoader

class GlideImageLoader: IImageLoader<ImageView> {
    override fun loadInto(url: String, container: ImageView) {
        Glide.with(container.context)
            .load(url)
            .into(container)
    }
}