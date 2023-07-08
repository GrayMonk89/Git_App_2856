package ru.graymonk.poplib.gitapp.di.module

import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.graymonk.poplib.gitapp.App
import ru.graymonk.poplib.gitapp.mvp.cache.IUsersCache
import ru.graymonk.poplib.gitapp.mvp.cache.UsersCacheImplementation
import ru.graymonk.poplib.gitapp.mvp.model.entity.room.DataBase
import ru.graymonk.poplib.gitapp.utils.AppConstants.USERS_DATA_BASE_NAME
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun dataBase(app: App): DataBase =
        Room.databaseBuilder(app, DataBase::class.java, USERS_DATA_BASE_NAME).build()

    @Singleton
    @Provides
    fun usersCache(dataBase: DataBase): IUsersCache = UsersCacheImplementation(dataBase)


}