package kev.njunge.androidofflinecache.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kev.njunge.androidofflinecache.data.UniversityDatabase
import kev.njunge.androidofflinecache.network.UniversityApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(UniversityApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideUniversityApi(retrofit: Retrofit): UniversityApi =
        retrofit.create(UniversityApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): UniversityDatabase =
        Room.databaseBuilder(app, UniversityDatabase::class.java, "university_database")
            .build()

}