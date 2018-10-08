package com.ik.navigationjetpack.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {


    companion object {

        val baseURL: String = "https://api.themoviedb.org/3/"
        var retrofit: Retrofit? = null

        val client: Retrofit
            get() {

                if (retrofit == null) {
                    retrofit = Retrofit.Builder()
                            .baseUrl(baseURL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                }
                return retrofit!!
            }
    }
}