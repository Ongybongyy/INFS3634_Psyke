package com.example.finalproject.entities.vocab;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface VocabService {
//    @GET("/api/v3/references/thesaurus/json/{word}?key=b9e02328-a613-480a-ba80-867cc0a1fddf")
//    Call<List<VocabResponse>> getThesaurusEntry(@Path("word") String word);
//
//    @GET("/api/v3/references/collegiate/json/{word}?key=956f275d-fbcf-4776-a24c-ef5bc98bc289")
//    Call<VocabResponse> getDictionaryEntry(@Path("word") String word);

    @GET("/api/2/7aea3bb4d052cf480f64464307759e9e/{word}/json")
    Call<VocabResponse> getThesaurusEntry(@Path("word") String word);
}
