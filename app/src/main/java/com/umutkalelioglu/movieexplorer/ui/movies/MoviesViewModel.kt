package com.umutkalelioglu.movieexplorer.ui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutkalelioglu.movieexplorer.common.Resource
import com.umutkalelioglu.movieexplorer.domain.usecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel // Hilt'in ViewModel'i tanıması için şart
class MoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    // UI'ın gözlemleyeceği tek gerçek (Source of Truth)
    private val _state = MutableStateFlow(MoviesState())
    val state: StateFlow<MoviesState> = _state

    init {
        // ViewModel oluştuğu an verileri çekmeye başla
        getMovies()
    }

    private fun getMovies() {
        // UseCase'i bir fonksiyon gibi çağırıyoruz
        getPopularMoviesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = MoviesState(
                        movies = result.data ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _state.value = MoviesState(
                        error = result.message ?: "Bilinmeyen bir hata"
                    )
                }
                is Resource.Loading -> {
                    _state.value = MoviesState(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope) // Coroutine içinde başlat
    }
}