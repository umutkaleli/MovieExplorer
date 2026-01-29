package com.umutkalelioglu.movieexplorer.domain.usecase

import com.umutkalelioglu.movieexplorer.common.Resource
import com.umutkalelioglu.movieexplorer.data.mapper.toMovie
import com.umutkalelioglu.movieexplorer.domain.model.Movie
import com.umutkalelioglu.movieexplorer.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())

            val moviesDto = repository.getPopularMovies(page = 1)

            // 3. DTO'yu Domain Modeline çevir
            // moviesDto.results bir List<MovieDto>.
            val movies = moviesDto.results.map { it.toMovie() }

            // 4. Başarılı veriyi gönder
            emit(Resource.Success(movies))

        } catch (e: HttpException) {
            // Sunucu hatası (404, 500 vs.)
            emit(Resource.Error(e.localizedMessage ?: "Beklenmedik bir hata oluştu"))

        } catch (e: IOException) {
            // İnternet yok veya bağlantı hatası
            emit(Resource.Error("Sunucuya ulaşılamıyor. İnternet bağlantınızı kontrol edin."))
        }
    }
}