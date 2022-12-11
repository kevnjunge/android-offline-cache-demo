package kev.njunge.androidofflinecache.data

import androidx.room.withTransaction
import kev.njunge.androidofflinecache.network.UniversityApi
import kev.njunge.androidofflinecache.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class UniversityRepository @Inject constructor(
    private val api: UniversityApi,
    private val db: UniversityDatabase
) {
    private val restaurantDao = db.universityDao()

    fun getUniversities() = networkBoundResource(
        query = {
            restaurantDao.getAllUniversities()
        },
        fetch = {
            delay(2000)
            api.getUniversity()
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                restaurantDao.deleteAllUniversities()
                restaurantDao.insertUniversity(restaurants)
            }
        }
    )
}
