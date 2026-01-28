package com.umutkalelioglu.movieexplorer.data.remote

import com.umutkalelioglu.movieexplorer.data.remote.dto.MoviesResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page: Int = 1,
        @Query("language") language: String = "en-US"
    ): MoviesResponseDto
}