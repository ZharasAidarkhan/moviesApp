package com.example.mvvm_movies_app.details.presentation

import com.example.mvvm_movies_app.movieList.domain.model.Movie

data class DetailsState(
    val isLoading: Boolean = false,
    val movie: Movie? = null
)
