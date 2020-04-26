package com.example.finalproject.entities.math;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MathService {
    @GET("/api/v1/arithmetic/simple.json")
    Call<MathResponse> getMathProblem(
            @Header("Authorization") String authToken
    );
    @GET("/api/v1/{subject}/{subtopic}.json")
    Call<MathResponse> getMathProblem(
            @Path("subject") String subject,
            @Path("subtopic") String subtopic,
            @Header("Authorization") String authToken
    );
    @GET("/api/v1/{subject}/{subtopic}.json")
    Call<MathResponse> getMathProblem(
            @Path("subject") String subject,
            @Path("subtopic") String subtopic,
            @Query("difficulty") String difficulty,
            @Header("Authorization") String authToken
    );
}
