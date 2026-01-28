package com.umutkalelioglu.movieexplorer.data.repository

import com.umutkalelioglu.movieexplorer.data.remote.MovieApi
import com.umutkalelioglu.movieexplorer.data.remote.dto.MoviesResponseDto
import com.umutkalelioglu.movieexplorer.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi
) : MovieRepository {

    override suspend fun getPopularMovies(page: Int): MoviesResponseDto {
        return api.getPopularMovies(page = page)
    }
}