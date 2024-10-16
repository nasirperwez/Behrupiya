package com.eramlab.behrupiya.presentation.ui.screens.History.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eramlab.behrupiya.R
import com.eramlab.behrupiya.presentation.viewmodel.HistoryImageViewModel
import java.io.File


@Composable
fun HistoryImage(
    historyImageViewModel: HistoryImageViewModel,
    modifier: Modifier = Modifier) {

    val imageList by historyImageViewModel.imageFiles.collectAsState()
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
            .background(color = Color(0xF23C3B3B))
            .padding(top = 40.dp)
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            columns = GridCells.Fixed(3), // 3 columns grid
            contentPadding = PaddingValues(20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(imageList) { imageFile ->
                HistoryCard(imageFile)
            }
        }
    }
}

@Composable
fun HistoryCard(imageFile: File) {
    Card(
        modifier = Modifier
            .aspectRatio(0.8f), // Make the card square-shaped
        shape = RoundedCornerShape(8.dp), // Reduce the rounded corners
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        onClick = {

        }
    ) {
        AsyncImage(
            model = imageFile,
            contentDescription = "History Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}
