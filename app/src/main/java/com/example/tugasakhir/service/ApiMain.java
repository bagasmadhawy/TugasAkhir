package com.example.tugasakhir.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {
    private Retrofit retrofit;

    public ClubRepository getApiClub(){
        String BASE_URL = "https://www.thesportsdb.com/";
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(ClubRepository.class);
    }
}
