package com.umutkalelioglu.movieexplorer.data.mapper

import com.umutkalelioglu.movieexplorer.data.remote.dto.MovieDto
import com.umutkalelioglu.movieexplorer.domain.model.Movie

// API(MovieDto) >> DOMAİN(Movie)
fun MovieDto.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        // API'den null gelirse varsayılan boş string atıyoruz.
        // Böylece UI katmanı null kontrolüyle uğraşmaz (Fail-Safe)
        posterPath = posterPath ?: "",
        voteAverage = voteAverage,
        releaseDate = releaseDate ?: ""
    )
}