package ru.graymonk.poplib.gitapp.mvp.model.network

import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single

interface INetworkStatus {

    fun isOnline(): Observer<Boolean>
    fun isOnlineSingle(): Single<Boolean>
}