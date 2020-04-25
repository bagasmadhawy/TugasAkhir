package com.example.tugasakhir.service;

import com.example.tugasakhir.model.club.ClubResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClubRepository {
    @GET("api/v1/json/1/search_all_teams.php?l=English Premier League")
    Call<ClubResponse> getClubR();
}
