package com.example.mealappcleanarchitecture.domain.repo

import com.example.mealappcleanarchitecture.data.remote.dto.CategoryFilterDto
import com.example.mealappcleanarchitecture.data.remote.dto.CategoryMealDto

interface CategoryRepo {

    suspend fun getCategories():CategoryMealDto
    suspend fun getFilterCategory(filter:String):CategoryFilterDto
}