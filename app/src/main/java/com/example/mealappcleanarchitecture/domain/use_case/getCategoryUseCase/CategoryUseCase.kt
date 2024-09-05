package com.example.mealappcleanarchitecture.domain.use_case.getCategoryUseCase


import com.example.mealappcleanarchitecture.data.remote.dto.toCategoryMeal
import com.example.mealappcleanarchitecture.domain.model.Category
import com.example.mealappcleanarchitecture.domain.repo.CategoryRepo
import com.example.mealappcleanarchitecture.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject


class CategoryUseCase @Inject constructor(private val repo:CategoryRepo) {

    fun executGetCategory():Flow<Resource<List<Category>>> = flow {
        try {
            emit(Resource.Loading())
            val categoryList=repo.getCategories()
            emit(Resource.Success(categoryList.toCategoryMeal()))
        }
        catch (e:IOException){
            emit(Resource.Error("No Connection.${e.localizedMessage}"))
        }
    }
}