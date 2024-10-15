package com.eramlab.behrupiya.presentation

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eramlab.behrupiya.presentation.ui.screens.generate.GenerateImageScreen
import com.eramlab.behrupiya.presentation.ui.screens.homescreen.HomeScreen
import com.eramlab.behrupiya.utils.NavigationRoutes
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.eramlab.behrupiya.data.model.Item
import com.eramlab.behrupiya.presentation.ui.onboarding.OnboardingScreen1
import com.eramlab.behrupiya.presentation.ui.screens.onboarding.OnboardingScreen2
import com.eramlab.behrupiya.presentation.ui.screens.onboarding.OnboardingScreen3
import com.eramlab.behrupiya.presentation.ui.screens.transparentDialog.TransparentDialog

import com.eramlab.behrupiya.presentation.ui.splash.SplashScreen
import com.eramlab.behrupiya.presentation.viewmodel.GenerateImageViewModel
import com.eramlab.behrupiya.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun ControlNav()
{
    val navController = rememberNavController() // Create NavController
    val sharedViewModel: SharedViewModel = viewModel()
    val generateImageViewModel: GenerateImageViewModel = viewModel()
    val homeViewModel: HomeViewModel = viewModel()
    generateImageViewModel.setSharedViewModel(sharedViewModel)
    LaunchedEffect(homeViewModel) {
        launch {
            homeViewModel.categories.collect { categories ->
                generateImageViewModel.setCategories(categories)
            }
        }
        launch {
            homeViewModel.selectedCategory.collect { category ->
                generateImageViewModel.setSelectedCategory(category)
            }
        }
        launch {
            homeViewModel.items.collect { items ->
                generateImageViewModel.setItems(items)
            }
        }
        launch {
            homeViewModel.isLoading.collect { isLoading ->
                generateImageViewModel.setLoading(isLoading)
            }
        }

        launch {
            homeViewModel.categoryData.collect { categoryData ->
                generateImageViewModel.setCategoryData(categoryData)
            }
        }
    }

    // Scaffold with NavHost
        Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            // Use Box or another layout composable that supports padding
            Box(modifier = Modifier.padding(innerPadding)) {
                NavHost(
                    navController = navController,
                    startDestination = NavigationRoutes.SPLASH
                ) {
                    // Splash Screen
                    composable(route = NavigationRoutes.SPLASH) {
                       SplashScreen(navController = navController)
                    }
                    // ONBOARDING Screen
                    composable(route = NavigationRoutes.ONBOARDING1) {
                        OnboardingScreen1(navController = navController)
                    }
                    composable(route = NavigationRoutes.ONBOARDING2) {
                        OnboardingScreen2(navController = navController)
                    }
                    composable(route = NavigationRoutes.ONBOARDING3) {
                        OnboardingScreen3(navController = navController)
                    }
                    //HOME Screen
                    composable(route = NavigationRoutes.HOME) {
                        HomeScreen(homeViewModel = homeViewModel,sharedViewModel = sharedViewModel,navController = navController)
                    }

                    //TRANSPARENT DIALOG Screen
                    composable(route = NavigationRoutes.TRANSPARENTDIALOG) {
                        TransparentDialog(sharedViewModel = sharedViewModel, navController = navController) {
                        }
                    }

                    composable(route = NavigationRoutes.GENERATE_SCREEN) {
                            GenerateImageScreen(
                                generateImageViewModel = generateImageViewModel,
                                sharedViewModel = sharedViewModel,
                                navController = navController,
                            )
                        }
                    }
            }
        }
    )
}




//class SharedViewModel : ViewModel() {
//    private val _bitmap = mutableStateOf<Bitmap?>(null)
//    val bitmap: State<Bitmap?> = _bitmap
//    var bitmap_set= _bitmap.value
//
//    val cItem - Item
//
//
//    private val _currentItem = mutableStateOf<Item?>(null)
//    val currentItem: State<Item?> = _currentItem
//
//
//    fun setBitmap(newBitmap: Bitmap) {
//        _bitmap.value = newBitmap
//        bitmap_set = newBitmap
//    }
//
//    fun setCurrentitem(currentItem: Item) {
//        currentItem = currentItem
//
//    }
//}

class SharedViewModel : ViewModel() {
    private val _bitmap = mutableStateOf<Bitmap?>(null)
    val bitmap: State<Bitmap?> = _bitmap
    var bitmap_set = _bitmap.value

    val cItem: Item? = null

    private val _currentItem = mutableStateOf<Item?>(null)
    val currentItem: State<Item?> = _currentItem

    // Approach 1: Kotlin property (recommended)
    val currentItemValue: Item?
        get() = _currentItem.value

    // Approach 2: Traditional getter method
    fun getCurrentItem(): Item? {
        return _currentItem.value
    }

    fun setBitmap(newBitmap: Bitmap) {
        _bitmap.value = newBitmap
        bitmap_set = newBitmap
    }

    fun setCurrentItem(item: Item) {
        _currentItem.value = item
    }

    // This function should be implemented in your SharedViewModel
    suspend fun loadFullResolutionImage(path: String): Bitmap? = withContext(Dispatchers.IO) {
        return@withContext try {
            BitmapFactory.decodeFile(path)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    fun processImage(path: String, onComplete: (Bitmap?) -> Unit) {
        viewModelScope.launch {
            val bitmap = loadFullResolutionImage(path)
            bitmap?.let { setBitmap(it) }
            onComplete(bitmap)
        }
    }

}

