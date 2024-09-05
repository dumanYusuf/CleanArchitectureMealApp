package com.example.mealappcleanarchitecture.presentation.categoryMeal

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealappcleanarchitecture.domain.use_case.getCategoryFilterUseCase.categoryFilterUseCase
import com.example.mealappcleanarchitecture.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CategoryFilterViewModel @Inject constructor(
    private val useCase: categoryFilterUseCase,
    private val stateHandle: SavedStateHandle,
    ):ViewModel(){


    private val _state= mutableStateOf<CategoryFilterState>(CategoryFilterState())
    val state: State<CategoryFilterState> =_state

    private var job: Job?=null



     fun getCategoryFilter(filter:String){
        Log.e("start","viewModellStart")
        job?.cancel()
        job=useCase.executeCategoryfilter(filter).onEach {
            when(it){
                is Resource.Success->{
                    _state.value=CategoryFilterState(categoryFilterList = it.data ?: emptyList())
                    Log.e("sucsess","Data Found:${it.data}")
                }
                is Resource.Error->{
                    _state.value=CategoryFilterState(errorMessage = it.message ?:"")
                    Log.e("Error","Error Not Found")
                }
                is Resource.Loading->{
                    _state.value=CategoryFilterState(isLoading = true)
                    Log.e("Loaading","data is loadind")
                }
            }
        }.launchIn(viewModelScope)
    }
}
