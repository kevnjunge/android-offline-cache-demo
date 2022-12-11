package kev.njunge.androidofflinecache.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [University::class], version = 1)
abstract class UniversityDatabase : RoomDatabase() {

    abstract fun universityDao(): UniversityDao

}