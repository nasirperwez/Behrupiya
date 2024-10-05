package com.eramlab.behrupiya.presentation.ui.screens.homescreen.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.eramlab.behrupiya.R
import com.eramlab.behrupiya.data.model.Item
import com.eramlab.behrupiya.presentation.SharedViewModel
import com.eramlab.behrupiya.utils.AppConstants
import com.eramlab.behrupiya.utils.NavigationRoutes

@Composable
fun ItemGrid(
    sharedViewModel: SharedViewModel,
    navController: NavController,
    modifier: Modifier = Modifier, items: List<Item>) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            ItemCard(sharedViewModel,navController,modifier, item)
        }
    }
}

@Composable
fun ItemCard(
    sharedViewModel: SharedViewModel,
    navController: NavController,
    modifier: Modifier = Modifier, item: Item) {
    Column(modifier = modifier) {
        Card(
            modifier = Modifier.fillMaxSize(),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            onClick = {
                sharedViewModel.setCurrentItem(item)
                navController.navigate(NavigationRoutes.TRANSPARENTDIALOG) {
                    popUpTo(NavigationRoutes.HOME) { inclusive = true }
                }
            }
        ) {
            AsyncImage(
                model = AppConstants.IMG_BASE_ENDPOINT + item.output_image,
                contentDescription = item.name,
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.default_lago),
                error = painterResource(id = R.drawable.default_lago)
            )
        }
        Text(
            text = item.name,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(), // Ensure the Text takes full width
            color = Color.White,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
    }
}
