package com.eramlab.behrupiya.presentation.ui.screens.generatescreennasir

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.R
import com.eramlab.behrupiya.presentation.ui.screens.generatescreennasir.compunent.GenerateTextSelect

@Composable
fun GenerateImageScreennasir(
//    onBackClick: () -> Unit,
//    onGalleryClick: () -> Unit,
//    onGenerateClick: () -> Unit,
//    onSaveShareClick: () -> Unit
) {
    var selectedImage by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopAppBar()
        Spacer(modifier = Modifier.height(16.dp))
        ImagePreviewCard(selectedImage)
        Spacer(modifier = Modifier.height(16.dp))
        ActionButtons()
        Spacer(modifier = Modifier.weight(1f))
        GenerateCardPreview()
    }
}

@Composable
private fun TopAppBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /* Handle back click */ }) {
            Icon(painter = painterResource(id = R.drawable.back_icn), contentDescription = "Back")
        }
        Text("Generate Image", fontSize = 20.sp)
        GenerateTextSelect()
        IconButton(onClick = { /* Handle gallery click */ }) {
            Icon(painter = painterResource(id = R.drawable.gallery_icn), contentDescription = "Gallery")
        }
    }
}

@Composable
private fun ImagePreviewCard(selectedImage: Int?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        if (selectedImage != null) {
            Image(
                painter = painterResource(id = selectedImage),
                contentDescription = "Generated Image",
                modifier = Modifier.fillMaxSize()
            )
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("No image generated yet")
            }
        }
    }
}

@Composable
private fun ActionButtons() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Generate")
        }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save / Share")
        }
    }
}

@Composable
private fun GenerateCardPreview() {
    // Placeholder for the GenerateCard component
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Generate Card Preview")
        }
    }
}