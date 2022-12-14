package kev.njunge.androidofflinecache.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UniversityDao {

    @Query("SELECT * FROM universities")
    fun getAllUniversities(): Flow<List<University>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUniversity(universities: List<University>)

    @Query("DELETE FROM universities")
    suspend fun deleteAllUniversities()
}