package com.umutkalelioglu.movieexplorer.di

import com.umutkalelioglu.movieexplorer.data.repository.MovieRepositoryImpl
import com.umutkalelioglu.movieexplorer.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(repository: MovieRepositoryImpl): MovieRepository {
        return repository
    }
}