package com.example.mvvm_movies_app.movieList.domain.repository

import com.example.mvvm_movies_app.movieList.domain.model.Movie
import com.example.mvvm_movies_app.movieList.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>>

    suspend fun getMovie(id:Int) : Flow<Resource<Movie>>
}