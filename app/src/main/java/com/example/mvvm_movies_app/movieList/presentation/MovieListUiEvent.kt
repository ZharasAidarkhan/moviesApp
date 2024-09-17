package com.example.mvvm_movies_app.movieList.presentation

import com.example.mvvm_movies_app.movieList.domain.model.Movie

sealed interface MovieListUiEvent {
    data class Paginate(val category: String) : MovieListUiEvent
    object Navigate : MovieListUiEvent
}