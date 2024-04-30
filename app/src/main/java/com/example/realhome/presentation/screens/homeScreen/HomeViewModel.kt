package com.example.realhome.presentation.screens.homeScreen

import androidx.lifecycle.ViewModel
import com.example.realhome.domain.useCases.useCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    useCases: useCases
) :ViewModel() {
    val getAllProperty=useCases.getAllPropertyUseCase()
}