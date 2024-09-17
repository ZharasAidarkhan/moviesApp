package com.example.mvvm_movies_app.movieList.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_movies_app.movieList.domain.repository.MovieListRepository
import com.example.mvvm_movies_app.movieList.util.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val movieListRepository: MovieListRepository
): ViewModel() {

    private val _movieListState = MutableStateFlow(MovieListState())
    val movieListState = _movieListState.asStateFlow()

    init {
        getPopularMoviesList(false)
        getUpcomingMovieList(false)
    }

    fun onEvent(event: MovieListUiEvent) {
        when(event) {
            MovieListUiEvent.Navigate -> {
                _movieListState.update {
                    it.copy(
                        isCurrentPopularScreen = !movieListState.value.isCurrentPopularScreen
                    )
                }
            }
            is MovieListUiEvent.Paginate -> {
                if(event.category == Category.POPULAR) {
                    getPopularMoviesList(true)
                }else if(event.category == Category.UPCOMING){
                    getUpcomingMovieList(true)
                }
            }
        }
    }

    private fun getPopularMoviesList(forceFetchFromRemote: Boolean) {
        viewModelScope.launch{
            _movieListState.update {
                it.copy(isLoading = true)
            }

            movieListRepository.getMovieList(
                forceFetchFromRemote,
                Category.POPULAR,
                movieListState.value.popularMovieListPage
            ).collectLatest {result ->
//                when(result) {
//
//                }
            }
        }
    }

    private fun getUpcomingMovieList(forceFetchFromRemote: Boolean) {

    }
}