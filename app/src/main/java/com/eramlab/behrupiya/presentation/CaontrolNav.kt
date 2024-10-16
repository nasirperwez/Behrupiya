package com.eramlab.behrupiya.presentation

import android.graphics.Bitmap
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope

import androidx.lifecycle.viewmodel.compose.viewModel
import com.eramlab.behrupiya.data.model.Item
import com.eramlab.behrupiya.presentation.ui.onboarding.OnboardingScreen1
import com.eramlab.behrupiya.presentation.ui.screens.History.HistoryScreen
import com.eramlab.behrupiya.presentation.ui.screens.onboarding.OnboardingScreen2
import com.eramlab.behrupiya.presentation.ui.screens.onboarding.OnboardingScreen3
import com.eramlab.behrupiya.presentation.ui.screens.transparentDialog.TransparentDialog

import com.eramlab.behrupiya.presentation.ui.splash.SplashScreen
import com.eramlab.behrupiya.presentation.viewmodel.GenerateImageViewModel
import com.eramlab.behrupiya.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun ControlNav()
{
    val navController = rememberNavController() // Create NavController
    val sharedViewModel: SharedViewModel = viewModel()
    val generateImageViewModel: GenerateImageViewModel = viewModel()
    val homeViewModel: HomeViewModel = viewModel()

    generateImageViewModel.setSharedViewModel(sharedViewModel)
    LaunchedEffect(homeViewModel , sharedViewModel.isFromHeader) {
        launch {
//            homeViewModel.categories.collect { categories ->
//                generateImageViewModel.setCategories(categories)
//            }
            if (sharedViewModel.isFromHeader) {
                homeViewModel.categoriesHeader
            } else {
                homeViewModel.categories
            }.collect { categories ->
                generateImageViewModel.setCategories(categories)
            }
        }
        launch {
//            homeViewModel.selectedCategory.collect { category ->
//                generateImageViewModel.setSelectedCategory(category)
//            }

            if (sharedViewModel.isFromHeader) {
                homeViewModel.selectedCategoryHeader
            } else {
                homeViewModel.selectedCategory
            }.collect { category ->
                generateImageViewModel.setSelectedCategory(category)
            }
        }
        launch {
//            homeViewModel.items.collect { items ->
//                generateImageViewModel.setItems(items)
//            }
            if (sharedViewModel.isFromHeader) {
                homeViewModel.itemsHeader
            } else {
                homeViewModel.items
            }.collect { items ->
                generateImageViewModel.setItems(items)
            }
        }
        launch {
            homeViewModel.isLoading.collect { isLoading ->
                generateImageViewModel.setLoading(isLoading)
            }
        }

        launch {
//            homeViewModel.categoryData.collect { categoryData ->
//                generateImageViewModel.setCategoryData(categoryData)
//            }

            if (sharedViewModel.isFromHeader) {
                homeViewModel.categoryDataHeader
            } else {
                homeViewModel.categoryData
            }.collect { categoryData ->
                generateImageViewModel.setCategoryData(categoryData)
            }
        }
    }



    // set generate screen data from Hadder

//    LaunchedEffect(homeViewModel) {
//        launch {
//            homeViewModel.categoriesHeader.collect { categoriesHeader ->
//                generateImageViewModel.setCategories(categoriesHeader)
//            }
//        }
//        launch {
//            homeViewModel.selectedCategoryHeader.collect { categoryHeader ->
//                generateImageViewModel.setSelectedCategory(categoryHeader)
//            }
//        }
//        launch {
//            homeViewModel.itemsHeader.collect { itemsHeader ->
//                generateImageViewModel.setItems(itemsHeader)
//            }
//        }
//        launch {
//            homeViewModel.isLoading.collect { isLoading ->
//                generateImageViewModel.setLoading(isLoading)
//            }
//        }
//
//        launch {
//            homeViewModel.categoryDataHeader.collect { categoryDataHeader ->
//                generateImageViewModel.setCategoryData(categoryDataHeader)
//            }
//        }
//    }



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
                    //History screen
                    composable(route = NavigationRoutes.HISTORY) {
                        HistoryScreen(homeViewModel = homeViewModel,sharedViewModel = sharedViewModel,navController = navController)
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


class SharedViewModel : ViewModel() {
    private val _bitmap = mutableStateOf<Bitmap?>(null)
    val bitmap: State<Bitmap?> = _bitmap
    var bitmap_set = _bitmap.value
    var isFromHeader by mutableStateOf(false)


    private val _currentItem = mutableStateOf<Item?>(null)
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

}

