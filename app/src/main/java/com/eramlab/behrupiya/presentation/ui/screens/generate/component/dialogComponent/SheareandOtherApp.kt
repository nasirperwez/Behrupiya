package com.eramlab.behrupiya.presentation.ui.screens.generate.component.dialogComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.eramlab.behrupiya.R

@Composable
fun SheareandOtherApp(modifier: Modifier) {

    Row(
        modifier = modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.social_whasapp),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clickable { }

        )
        Image(painter = painterResource(id = R.drawable.social_facebook),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 20.dp)
                .size(40.dp)
                .clickable { }

        )
        Image(painter = painterResource(id = R.drawable.social_instgram),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 20.dp)
                .size(40.dp)
                .clickable { }

        )
    }
}