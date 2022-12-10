package kev.njunge.androidofflinecache.network

import kev.njunge.androidofflinecache.data.University
import retrofit2.http.GET

interface UniversityApi {

    companion object{
        const val BASE_URL = "http://universities.hipolabs.com/"
    }

    @GET("search?name=middle")
    suspend fun getUniversity():List<University>

}