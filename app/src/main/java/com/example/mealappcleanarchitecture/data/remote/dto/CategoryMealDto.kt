package com.example.mealappcleanarchitecture.data.remote.dto

import com.example.mealappcleanarchitecture.domain.model.Category


data class CategoryMealDto(
    val categories: List<CategoryDto>
)

fun CategoryMealDto.toCategoryMeal():List<Category>{
    return categories.map { Category(it.idCategory,it.strCategory,it.strCategoryThumb,it.strCategoryDescription) }
}




