package com.umutkalelioglu.movieexplorer.domain.repository

import com.umutkalelioglu.movieexplorer.data.remote.dto.MoviesResponseDto

interface MovieRepository {
    suspend fun getPopularMovies(page: Int): MoviesResponseDto
}