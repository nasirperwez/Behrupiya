package com.eramlab.behrupiya.presentation.ui.screens.generate.component.generateyopbarcomponent

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.eramlab.behrupiya.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.navigation.NavController
import com.eramlab.behrupiya.utils.NavigationRoutes


@Composable
fun backButton(navController: NavController, modifier: Modifier) {
    IconButton(
        onClick = { navController.navigate(NavigationRoutes.TRANSPARENTDIALOG) },
        modifier = modifier
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(id = R.drawable.back_icn),
            contentDescription = null,
        )
    }
}