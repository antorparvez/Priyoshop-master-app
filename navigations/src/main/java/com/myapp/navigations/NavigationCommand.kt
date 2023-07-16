package com.myapp.navigations

import androidx.navigation.NavDirections


sealed class NavigationCommand {
    data class To(val directions: NavDirections): NavigationCommand()
    object Back: NavigationCommand()
}