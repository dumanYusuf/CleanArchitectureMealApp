package com.example.mealappcleanarchitecture.domain.use_case.getCategoryFilterUseCase

import android.util.Log
import com.example.mealappcleanarchitecture.data.remote.dto.toCategoryFilter
import com.example.mealappcleanarchitecture.domain.model.CategoryFilter
import com.example.mealappcleanarchitecture.domain.repo.CategoryRepo
import com.example.mealappcleanarchitecture.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class categoryFilterUseCase @Inject constructor(private val repo: CategoryRepo){


    fun executeCategoryfilter(filter:String):Flow<Resource<List<CategoryFilter>>> = flow {

        try {
            val categoryfilterList=repo.getFilterCategory(filter)

            if (categoryfilterList.meals!=null){
                emit(Resource.Success(categoryfilterList.toCategoryFilter()))
                Log.e("sucsess","data found ")
            }
            else{
                Log.e("usecase","data not found")
            }
        }
        catch (e:Exception){
            emit(Resource.Error("Error"))
            Log.e("error","data not found:${e.localizedMessage}")
        }
    }
}