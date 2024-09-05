package com.example.mealappcleanarchitecture.presentation.categoryFilterMeal

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealappcleanarchitecture.domain.model.Category
import com.example.mealappcleanarchitecture.domain.use_case.getCategoryUseCase.CategoryUseCase
import com.example.mealappcleanarchitecture.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CategoryViewModel @Inject constructor(private val useCase: CategoryUseCase):ViewModel(){



    private val _state= mutableStateOf<CategoryState>(CategoryState())
    val state:State<CategoryState> =_state

   private var job:Job ?=null

    init {
        getCategoty()
    }

   private fun getCategoty(){
       Log.e("getCategory","start")
       job?.cancel()
       job= useCase.executGetCategory().onEach {
           when(it){
               is Resource.Success->{
                   _state.value=CategoryState(categoryList = it.data ?: emptyList())
                   Log.e("sucsess","data found:${it.data}")
               }
               is Resource.Error->{
                   _state.value=CategoryState(errorMessage = it.message ?:"null")
                   Log.e("Error","data not found:")
               }
               is Resource.Loading->{
                   _state.value=CategoryState(isLoading = true)
                   Log.e("loading","data is loading:")
               }
           }
       }.launchIn(viewModelScope)
   }

}