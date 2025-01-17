package com.example.mvvm_movies_app.movieList.data.remote

import com.example.mvvm_movies_app.movieList.data.remote.response.MovieListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/{category}")
    suspend fun getMovieList(
        @Path("category") category: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = API_KEY
    ) : MovieListDto

    companion object{
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_BASE_URL = "https://www.themoviedb.org/t/p/w500"
        const val API_KEY = "b30a571b5d9cc77b02b1101df5b6ed25"
    }
}