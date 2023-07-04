package ru.graymonk.poplib.gitapp.mvp.model.entity.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import ru.graymonk.poplib.gitapp.mvp.model.entity.room.RoomGitHubUser

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RoomGitHubUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: List<RoomGitHubUser>): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg user: RoomGitHubUser)

    @Update
    fun update(user: RoomGitHubUser)

    @Delete
    fun delete(user: RoomGitHubUser)

    @Delete
    fun delete(user: List<RoomGitHubUser>)

    @Delete
    fun delete(vararg user: RoomGitHubUser)

    @Query("SELECT * FROM RoomGitHubUser")
    fun getAll(): Single<List<RoomGitHubUser>>

    @Query("SELECT * FROM RoomGitHubUser WHERE login = :login LIMIT 1")
    fun findByLogin(login: String): RoomGitHubUser?
}