package com.example.mealappcleanarchitecture.presentation.categoryMeal.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import com.example.mealappcleanarchitecture.domain.model.Category
import com.example.mealappcleanarchitecture.presentation.Screen
import com.example.mealappcleanarchitecture.presentation.categoryMeal.CategoryFilterViewModel
import com.google.gson.Gson
import java.net.URLEncoder

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CategoryFilterScreen(
    navController: NavController,
    categoryObject:Category,
    viewModel: CategoryFilterViewModel= hiltViewModel()
) {

    val state=viewModel.state.value
    val context= LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.getCategoryFilter(categoryObject.strCategory)
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = categoryObject.strCategory)
            })
        },
        content = {innerPadding->
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                columns = GridCells.Fixed(2)) {
                items(viewModel.state.value.categoryFilterList){filterCategory->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .size(250.dp)
                    ) {
                        Text(text = filterCategory.strMeal)
                        Image(
                            modifier = Modifier
                                .size(250.dp)
                                .clickable {
                                    val objectCategory=Gson().toJson(filterCategory)
                                    val encodedJsonMeal = URLEncoder.encode(objectCategory, "UTF-8")
                                    navController.navigate(Screen.CategoryDetailPage.route+"/$encodedJsonMeal")
                                },
                            painter = rememberAsyncImagePainter(model = filterCategory.strMealThumb, imageLoader = ImageLoader(context) ),
                            contentDescription =null , contentScale = ContentScale.Crop)

                    }
                }
            }
        }
    )
}