package com.eramlab.behrupiya.presentation.ui.screens.generate.component.GenerateAndSave


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eramlab.behrupiya.R
import com.eramlab.behrupiya.presentation.SharedViewModel
import com.eramlab.behrupiya.presentation.viewmodel.GenerateImageViewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GenerateAndSaveBox(
    isRegenerate : Int,
    sharedViewModel: SharedViewModel,
    generateImageViewModel: GenerateImageViewModel,
    onGenerateClick:  () -> Unit,
) {
    val blueGradient = Brush.verticalGradient(
        colors = listOf(Color(0xFF01CEF0), Color(0xFF0357C0)) // Two colors for the gradient
    )
    var text ="Generate"
    if(isRegenerate==2)
            text = "reGenerate"



    Box(
        Modifier
            .clip(
                RoundedCornerShape(
                    30.dp
                )
            )
            .background(color = Color(0xC3202027))
            .height(50.dp)
            .fillMaxWidth(0.75f)


    ){
        Row {
            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            30.dp
                        )
                    )
                    .background(blueGradient)
                    .height(50.dp)
                    .fillMaxWidth(0.70f)
                    .clickable { sharedViewModel.bitmap_set?.let {
                        generateImageViewModel.setGenerating(1)
                        val prompt = sharedViewModel.getCurrentItem()?.prompt
                        if (prompt != null) {
                            generateImageViewModel.onGenerateImage(
                                it,prompt)
                        }
                        onGenerateClick()
                    } }

            )
            {
                Text(

                    text = text,
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    fontSize = 15.sp
                )
            }
            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            30.dp
                        )
                    )
                    .background(color = Color.Transparent)
                    .height(50.dp)
                    .fillMaxWidth()
                    .clickable { }

            ) {
                Image(
                    painter = painterResource(id = R.drawable.add_img),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                )
            }


        }
    }
}

