package com.example.mealappcleanarchitecture.data.di

import com.example.mealappcleanarchitecture.data.remote.MealApi
import com.example.mealappcleanarchitecture.data.repo.CategoryRepoImpl
import com.example.mealappcleanarchitecture.domain.model.CategoryFilter
import com.example.mealappcleanarchitecture.domain.repo.CategoryRepo
import com.example.mealappcleanarchitecture.util.Constans
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    @Singleton
    @Provides
     fun providesgetCategory():MealApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constans.BASE_URL)
            .build().create(MealApi::class.java)
    }


    @Singleton
    @Provides
    fun provideCategoryRepo(api: MealApi):CategoryRepo{
        return CategoryRepoImpl(api)
    }



}