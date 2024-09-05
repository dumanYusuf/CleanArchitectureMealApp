package com.example.mealappcleanarchitecture.data.remote

import com.example.mealappcleanarchitecture.data.remote.dto.CategoryFilterDto
import com.example.mealappcleanarchitecture.data.remote.dto.CategoryMealDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {


    @GET("/api/json/v1/1/categories.php ")
    suspend fun getCategory():CategoryMealDto

    @GET("/api/json/v1/1/filter.php?c=Seafood")
    suspend fun getCategoryFilter(
        @Query(value = "c") c:String
    ):CategoryFilterDto

}