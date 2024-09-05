package com.example.mealappcleanarchitecture.data.remote.dto

import com.example.mealappcleanarchitecture.domain.model.CategoryFilter

data class CategoryFilterDto(
    val meals: List<MealFilterDto>
)

fun CategoryFilterDto.toCategoryFilter():List<CategoryFilter>{
    return meals.map { CategoryFilter(it.idMeal,it.strMeal,it.strMealThumb) }
}