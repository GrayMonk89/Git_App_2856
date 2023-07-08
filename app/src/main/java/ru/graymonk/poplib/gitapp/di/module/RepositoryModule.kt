package ru.graymonk.poplib.gitapp.di.module

import dagger.Module
import dagger.Provides
import ru.graymonk.poplib.gitapp.mvp.cache.IUsersCache
import ru.graymonk.poplib.gitapp.mvp.model.api.IDataSource
import ru.graymonk.poplib.gitapp.mvp.model.network.INetworkStatus
import ru.graymonk.poplib.gitapp.mvp.model.repository.IGitHubUsersRepository
import ru.graymonk.poplib.gitapp.mvp.model.repository.retrofit.RetrofitGitHubUserRepositoryImplementation
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun usersRepository(
        api: IDataSource,
        networkStatus: INetworkStatus,
        cache: IUsersCache
    ): IGitHubUsersRepository =
        RetrofitGitHubUserRepositoryImplementation(api, networkStatus, cache)

//    fun usersRepositoriesRepository(
//        api: IDataSource,
//        networkStatus: INetworkStatus,
//        cache: IUsersCache
//    ): IRetrofitGitHubUserRepositoriesRepository =
//        RetrofitGitHubUserRepositoriesRepositoryImplementation(api, networkStatus, cache)

}