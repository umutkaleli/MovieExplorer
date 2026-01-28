package com.umutkalelioglu.movieexplorer.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: Double,
    val releaseDate: String
)