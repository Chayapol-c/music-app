package com.example.musicapp.ui.screen.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.rememberScaffoldState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.musicapp.ui.organisms.MainBottomSheet
import com.example.musicapp.ui.organisms.AccountDialog
import com.example.musicapp.ui.molecules.MainDrawerItem
import com.example.musicapp.ui.Navigation
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
    val bottomBar: @Composable () -> Unit = {
        if (currentScreen is Screen.DrawerScreen || currentScreen == Screen.BottomScreen.Home) {
            BottomNavigation(
                modifier = Modifier.wrapContentSize()
            ) {
                screenInBottom.forEach { item ->
                    val tint = if (item.bRoute == currentRoute) {
                        Color.White
                    } else {
                        Color.Black
                    }
                    BottomNavigationItem(
                        selected = item.bRoute == currentRoute,
                        onClick = {
                            controller.navigate(item.bRoute)
                            title.value = item.title
                        },
                        icon = {

                            Icon(
                                tint = tint,
                                painter = painterResource(item.icon),
                                contentDescription = item.title
                            )
                        },
                        label = {
                            Text(text = item.bTitle, color = tint)
                        },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Black,
                    )
                }
            }
        }
    }

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
                TopAppBar(
                    title = { Text(text = title.value) },
                    actions = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    if (modalSheetState.isVisible) {
                                        modalSheetState.hide()
                                    } else {
                                        modalSheetState.show()
                                    }
                                }
                            }
                        ) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "more")
                        }
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                        ) {
                            Icon(
                                Icons.Default.AccountCircle,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            },
            bottomBar = bottomBar,
            scaffoldState = scaffoldState,
            drawerContent = {
                LazyColumn(
                    modifier = Modifier.padding(16.dp),
                ) {
                    items(screenInDrawer) { item ->
                        MainDrawerItem(
                            selected = item.route == currentRoute,
                            item = item,
                            onDrawerItemClicked = {
                                scope.launch {
                                    scaffoldState.drawerState.close()
                                }
                                if (item.dRoute == "add_account") {
                                    dialogOpen.value = true
                                } else {
                                    controller.navigate(item.dRoute)
                                    title.value = item.dTitle
                                }
                            })
                    }
                }
            }
        )
        {
            Navigation(
                navController = controller,
                pd = it
            )

            AccountDialog(dialogOpen = dialogOpen)
        }
    }

}
