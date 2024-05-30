package com.example.realhome.presentation.screens.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.data.mappers.toProperty
import com.example.realhome.domain.model.Property
import com.example.realhome.domain.useCases.useCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    useCases: useCases
    ,pager: Pager<Int,Property>
) :ViewModel() {
    val getAllProperty=useCases.getAllPropertyUseCase()

    val propertyPagingFlow= pager.flow.map { pagingData -> pagingData.map { it.toProperty() }}.cachedIn(viewModelScope)


}