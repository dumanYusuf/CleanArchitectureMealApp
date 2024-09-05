package com.example.mealappcleanarchitecture.presentation.categoryMeal

import com.example.mealappcleanarchitecture.domain.model.CategoryFilter

data class CategoryFilterState(
    val isLoading:Boolean=false,
    val categoryFilterList: List<CategoryFilter> = emptyList(),
    val errorMessage:String=""
)
