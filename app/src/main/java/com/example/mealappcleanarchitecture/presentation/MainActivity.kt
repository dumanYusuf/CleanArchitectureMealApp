package com.example.mealappcleanarchitecture.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealappcleanarchitecture.domain.model.Category
import com.example.mealappcleanarchitecture.presentation.categoryFilterMeal.views.CategoryScreen
import com.example.mealappcleanarchitecture.presentation.categoryMeal.views.CategoryFilterScreen
import com.example.mealappcleanarchitecture.ui.theme.MealAppCleanArchitectureTheme
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.net.URLDecoder


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealAppCleanArchitectureTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    //CategoryScreen()
                    ControllerNav()
                }
            }
        }
    }
}


@Composable
fun ControllerNav() {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Screen.CategoryScreen.route) {
        composable(Screen.CategoryScreen.route){
            CategoryScreen(navController)
        }
        composable(Screen.CategoryFilterScreen.route+"/{categoryObject}",
            arguments = listOf(
                navArgument("categoryObject"){type= NavType.StringType}
            )
        ){
            val jsonMeal = it.arguments?.getString("categoryObject")
            val decodedJsonMeal = URLDecoder.decode(jsonMeal, "UTF-8")
            val mealObject = Gson().fromJson(decodedJsonMeal, Category::class.java)
           CategoryFilterScreen(navController = navController, categoryObject =mealObject )
        }
    }
}

