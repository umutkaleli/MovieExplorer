package com.umutkalelioglu.movieexplorer.ui.movies

import com.umutkalelioglu.movieexplorer.domain.model.Movie

data class MoviesState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)