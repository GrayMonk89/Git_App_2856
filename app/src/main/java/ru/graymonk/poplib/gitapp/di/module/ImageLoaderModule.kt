package ru.graymonk.poplib.gitapp.di.module

import android.widget.ImageView
import dagger.Module
import dagger.Provides
import ru.graymonk.poplib.gitapp.mvp.view.IImageLoader
import ru.graymonk.poplib.gitapp.ui.image.GlideImageLoader
import javax.inject.Singleton

@Module
class ImageLoaderModule {
    @Singleton
    @Provides
    fun loadInto(): IImageLoader<ImageView> = GlideImageLoader()
}