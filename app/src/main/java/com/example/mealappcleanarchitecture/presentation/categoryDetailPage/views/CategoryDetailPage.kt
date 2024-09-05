package com.example.mealappcleanarchitecture.presentation.categoryDetailPage.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import com.example.mealappcleanarchitecture.domain.model.Category
import com.example.mealappcleanarchitecture.domain.model.CategoryFilter

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CategoryDetailPage(
    categoryfilter:CategoryFilter
) {

    val context= LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text =categoryfilter.strMeal)})
        },
        content = {
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                Card(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        modifier = Modifier.fillMaxWidth(),
                        painter = rememberAsyncImagePainter(model = categoryfilter.strMealThumb, imageLoader = ImageLoader(context)),
                        contentDescription = "", contentScale = ContentScale.Crop)
                }
            }
        }
    )
}