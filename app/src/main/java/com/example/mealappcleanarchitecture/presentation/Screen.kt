package com.example.mealappcleanarchitecture.presentation

sealed class Screen(val route:String) {

    object CategoryScreen:Screen("category_screen")
    object CategoryFilterScreen:Screen("category_filter_screen")
    object CategoryDetailPage:Screen("category_detail_page")

}