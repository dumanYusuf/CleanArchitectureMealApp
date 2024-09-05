package com.example.mealappcleanarchitecture.data.repo

import com.example.mealappcleanarchitecture.data.remote.MealApi
import com.example.mealappcleanarchitecture.data.remote.dto.CategoryDto
import com.example.mealappcleanarchitecture.data.remote.dto.CategoryFilterDto
import com.example.mealappcleanarchitecture.data.remote.dto.CategoryMealDto
import com.example.mealappcleanarchitecture.domain.model.CategoryFilter
import com.example.mealappcleanarchitecture.domain.repo.CategoryRepo
import javax.inject.Inject


class CategoryRepoImpl @Inject constructor(private val api: MealApi):CategoryRepo {
    override suspend fun getCategories(): CategoryMealDto {
        return api.getCategory()
    }

    override suspend fun getFilterCategory(filter:String): CategoryFilterDto {
       return api.getCategoryFilter(c = filter)
    }
}