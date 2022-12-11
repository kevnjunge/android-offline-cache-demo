package kev.njunge.androidofflinecache.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "universities")
data class University(
    @PrimaryKey val name: String,
    val country: String,

)