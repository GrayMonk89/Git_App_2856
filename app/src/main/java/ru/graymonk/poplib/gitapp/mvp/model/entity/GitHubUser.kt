package ru.graymonk.poplib.gitapp.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubUser(
    @Expose val id: String,
    @Expose val login: String,
    @Expose val avatarUrl: String? = null,
    @Expose
    @SerializedName("repos_url")
    val reposeUrl: String? = null
) : Parcelable
