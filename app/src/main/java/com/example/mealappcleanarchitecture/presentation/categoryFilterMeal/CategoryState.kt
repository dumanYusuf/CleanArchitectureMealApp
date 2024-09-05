package com.example.mealappcleanarchitecture.presentation.categoryFilterMeal

import com.example.mealappcleanarchitecture.domain.model.Category

data class CategoryState(
    val isLoading:Boolean =false,
    val categoryList:List<Category> = emptyList(),
    val errorMessage:String=""
)