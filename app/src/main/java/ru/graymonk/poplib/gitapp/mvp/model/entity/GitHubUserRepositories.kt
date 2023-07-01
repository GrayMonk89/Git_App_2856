package ru.graymonk.poplib.gitapp.mvp.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubUserRepositories(
    @Expose val id: String,
    @Expose val name: String? = null,
    @Expose val forksCount: Int? = null
) : Parcelable