package com.example.musicapp.ui.screen.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.rememberScaffoldState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.musicapp.ui.components.organisms.MainBottomSheet
import com.example.musicapp.ui.components.organisms.OrganismAccountDialog
import com.example.musicapp.ui.Navigation
import com.example.musicapp.ui.components.organisms.OrganismBottomBar
import com.example.musicapp.ui.components.organisms.OrganismMainDrawer
import com.example.musicapp.ui.components.organisms.OrganismTopAppBar
import com.example.musicapp.ui.screen.Screen
import com.example.musicapp.ui.screen.screenInBottom
import com.example.musicapp.ui.screen.screenInDrawer
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainView() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val viewModel: MainViewModel = viewModel()
    val controller = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val isSheetFullScreen by remember { mutableStateOf(false) }
    val modifier = if (isSheetFullScreen) Modifier.fillMaxSize() else Modifier.fillMaxWidth()
    val modalSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = {
            it != ModalBottomSheetValue.HalfExpanded
        }
    )
    val roundedCornerRadius = if (isSheetFullScreen) 0.dp else 12.dp

    val currentScreen = remember { viewModel.currentScreen.value }
    val title = remember { mutableStateOf(currentScreen.title) }
    val dialogOpen = remember { mutableStateOf(false) }

    ModalBottomSheetLayout(
        sheetState = modalSheetState,
        sheetShape = RoundedCornerShape(
            topStart = roundedCornerRadius,
            topEnd = roundedCornerRadius
        ),
        sheetContent = {
            MainBottomSheet(modifier = modifier)
        }
    ) {
        Scaffold(
            topBar = {
                OrganismTopAppBar(
                    title = title.value,
                    onNavigationClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    },
                    onActionClick = {
                        scope.launch {
                            if (modalSheetState.isVisible) {
                                modalSheetState.hide()
                            } else {
                                modalSheetState.show()
                            }
                        }
                    }
                )
            },
            bottomBar = {
                OrganismBottomBar(
                    currentMenu = currentRoute ?: "",
                    onChangeMenu = {
                        controller.navigate(it.bRoute)
                        title.value = it.title
                    },
                    isDisplay = currentScreen is Screen.DrawerScreen || currentScreen == Screen.BottomScreen.Home,
                    navigationMenuList = screenInBottom
                )
            },
            scaffoldState = scaffoldState,
            drawerContent = {
                OrganismMainDrawer(
                    currentRoute = currentRoute ?: "",
                    menuList = screenInDrawer,
                    onMenuItemClick = { item ->
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }
                        if (item.dRoute == "add_account") {
                            dialogOpen.value = true
                        } else {
                            controller.navigate(item.dRoute)
                            title.value = item.dTitle
                        }
                    }
                )
            }
        )
        {
            Navigation(
                navController = controller,
                pd = it
            )

            OrganismAccountDialog(dialogOpen = dialogOpen)
        }
    }

}
