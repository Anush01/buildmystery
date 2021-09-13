package com.example.anushmp.retromovies;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("movies _db")
    Call<ApiResponse> getMovies();

}
