package com.kanyideveloper.joomia.feature_products.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kanyideveloper.joomia.core.util.Resource
import com.kanyideveloper.joomia.core.util.UiEvents
import com.kanyideveloper.joomia.feature_products.domain.use_case.GetCategoriesUseCase
import com.kanyideveloper.joomia.feature_products.domain.use_case.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getCategoriesUseCase: GetCategoriesUseCase,
) :
    ViewModel() {

    private val _selectedCategory = mutableStateOf("All")
    val selectedCategory: State<String> = _selectedCategory
    fun setCategory(value: String) {
        _selectedCategory.value = value
    }

    private val _productsState = mutableStateOf(ProductsState())
    val productsState: State<ProductsState> = _productsState

    private val _categoriesState = mutableStateOf(emptyList<String>())
    val categoriesState: State<List<String>> = _categoriesState

    private val _bannerImageState =
        mutableStateOf("https://firebasestorage.googleapis.com/v0/b/mealtime-7a501.appspot.com/o/tinywow_Joomia%20Black%20Friday_16608968%20(1).png?alt=media&token=8b874def-e543-482e-80f7-c8cbe9d9f206")
    val bannerImageState: State<String> = _bannerImageState

    private val _searchTerm = mutableStateOf("")
    val searchTerm: State<String> = _searchTerm

    fun setSearchTerm(term: String) {
        _searchTerm.value = term
    }

    private val _eventFlow = MutableSharedFlow<UiEvents>()
    val eventFlow: SharedFlow<UiEvents> = _eventFlow.asSharedFlow()

    init {
        getProducts(selectedCategory.value)
        getCategories()

    }

    private fun getCategories() {
        viewModelScope.launch {
            _categoriesState.value = getCategoriesUseCase()
        }
    }

    fun getProducts(category: String = "All", searchTerm: String = "") {
        viewModelScope.launch {
            getProductsUseCase().collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        if (category == "All") {
                            _productsState.value = productsState.value.copy(
                                products = if (searchTerm.isEmpty()) {
                                    result.data ?: emptyList()
                                } else {
                                    result.data?.filter {
                                        it.title.contains(
                                            searchTerm,
                                            ignoreCase = true
                                        )
                                    } ?: emptyList()
                                },
                                isLoading = false
                            )
                        } else {
                            _productsState.value = productsState.value.copy(
                                products = result.data?.filter { it.category == category }
                                    ?: emptyList(),
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _productsState.value = productsState.value.copy(
                            isLoading = true
                        )
                    }
                    is Resource.Error -> {
                        _productsState.value = productsState.value.copy(
                            isLoading = false,
                            error = result.message
                        )
                        _eventFlow.emit(
                            UiEvents.SnackbarEvent(
                                message = result.message ?: "Unknown error occurred!"
                            )
                        )
                    }
                }
            }
        }
    }
}