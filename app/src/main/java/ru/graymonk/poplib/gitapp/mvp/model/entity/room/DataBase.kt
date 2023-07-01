package ru.graymonk.poplib.gitapp.mvp.model.entity.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.graymonk.poplib.gitapp.mvp.model.entity.room.dao.RepositoryDao
import ru.graymonk.poplib.gitapp.mvp.model.entity.room.dao.UserDao
import java.lang.RuntimeException

@androidx.room.Database(
    entities = [RoomGitHubUser::class, RoomGitHubRepository::class],
    version = 1
)

abstract class DataBase : RoomDatabase() {

    abstract val userDao: UserDao
    abstract val repositoryDao: RepositoryDao

    companion object {
        private const val DATA_BASE_NAME = "datadase.db"
        private var instance: DataBase? = null

        fun getInstance() = instance ?: throw RuntimeException("DataBase has not been created")

        fun createDataBase(context: Context?) {
            if (instance == null)
                instance =
                    Room.databaseBuilder(context!!, DataBase::class.java, DATA_BASE_NAME).build()
        }
    }
}