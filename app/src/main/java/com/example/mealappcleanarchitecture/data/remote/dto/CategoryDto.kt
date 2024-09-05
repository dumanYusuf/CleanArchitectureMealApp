package com.example.mealappcleanarchitecture.data.remote.dto

import com.example.mealappcleanarchitecture.domain.model.Category

data class CategoryDto(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String,

)

