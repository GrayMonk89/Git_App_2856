package ru.graymonk.poplib.gitapp.mvp.model.entity.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ru.graymonk.poplib.gitapp.mvp.model.entity.room.RoomGitHubRepository

@Dao
interface RepositoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: RoomGitHubRepository)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: List<RoomGitHubRepository>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg user: RoomGitHubRepository)

    @Update
    fun update(user: RoomGitHubRepository)

    @Delete
    fun delete(user: RoomGitHubRepository)

    @Delete
    fun delete(user: List<RoomGitHubRepository>)

    @Delete
    fun delete(vararg user: RoomGitHubRepository)

    @Query("SELECT * FROM RoomGitHubRepository")
    fun getAll(): List<RoomGitHubRepository>

    @Query("SELECT * FROM RoomGitHubRepository WHERE userId = :userId")
    fun findForUser(userId: String): List<RoomGitHubRepository>
}