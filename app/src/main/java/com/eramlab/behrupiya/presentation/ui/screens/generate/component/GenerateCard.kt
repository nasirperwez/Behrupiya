package com.eramlab.behrupiya.presentation.ui.screens.generate.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eramlab.behrupiya.data.model.Item
import com.eramlab.behrupiya.data.model.genImg

@Composable
fun CardItem(item: Item) {

    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(), // Ensure the column fills the width
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(4.dp)
            //.aspectRatio(1f)

        ) {

            Card(
                modifier = Modifier
                    .width(100.dp)
                    .height(120.dp)
                    .shadow(elevation = 0.dp, shape = RoundedCornerShape(20.dp)),

                ) {
//                AsyncImage(
//                    model = item.output_image,
//                    contentDescription = item.name,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .aspectRatio(1f),
//                    contentScale = ContentScale.Crop
//
//                )
            }
        }

        Box(
            modifier = Modifier
                .width(100.dp)
        ) {
            Text(
                text = item.name,
                modifier = Modifier.align(Alignment.Center),
                color = Color.White
            )
        }

    }

}

@Composable
fun GenerateCard(
    items:List<Item>,
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    modifier: Modifier = Modifier) {
    val abhi = remember { genImg() }
    LazyHorizontalGrid(
        modifier = modifier.padding(),
        rows = GridCells.Fixed(1),

        ) {
        items(items) { item ->
            CardItem(item)
        }
    }
}