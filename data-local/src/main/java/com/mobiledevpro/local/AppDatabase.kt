package com.mobiledevpro.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mobiledevpro.local.dao.UserDao
import com.mobiledevpro.local.model.UserEntity

/**
 * Room Database
 *
 * Created by Dmitriy Chernysh on 11/12/19.
 *
 * http://androiddev.pro
 *
 * #MobileDevPro
 */

@Database(
        entities = [
            UserEntity::class
        ],
        version = BuildConfig.RoomDatabaseVersion,
        exportSchema = true
)

internal abstract class AppDatabase : RoomDatabase() {
    internal abstract val userDao: UserDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java,
                            "app_database")
                            .fallbackToDestructiveMigration()
                            .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}

