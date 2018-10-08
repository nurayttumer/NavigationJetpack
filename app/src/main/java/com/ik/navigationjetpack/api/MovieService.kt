package com.ik.navigationjetpack.api

import com.ik.navigationjetpack.models.MovieResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("movie/top_rated?")
    fun getTopRatedMovies(@Query("api_key") apiKey: String): Call<MovieResponse>

    @GET("movie/{id}")
    fun getMovieDetails(@Path("id") id: Int, @Query("api_key") apiKey: String): Call<MovieResponse>
}