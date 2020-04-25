package com.example.tugasakhir.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tugasakhir.model.club.ClubResponse;
import com.example.tugasakhir.model.club.ClubTeamsItem;
import com.example.tugasakhir.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClubViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<ClubTeamsItem>> listDiscoverClub = new MutableLiveData<>();

    public void setClubDiscover(){
        if (this.apiMain == null){
            apiMain = new ApiMain();

            apiMain.getApiClub().getClubR().enqueue(new Callback<ClubResponse>() {
                @Override
                public void onResponse(Call<ClubResponse> call, Response<ClubResponse> response) {
                    ClubResponse responseDiscovery = response.body();
                    if (responseDiscovery != null && responseDiscovery.getTeams() != null){
                        ArrayList<ClubTeamsItem> ClubDiscoverItems = responseDiscovery.getTeams();
                        listDiscoverClub.postValue(ClubDiscoverItems);
                    }
                }

                @Override
                public void onFailure(Call<ClubResponse> call, Throwable t) {

                }
            });
        }
    }
    public LiveData<ArrayList<ClubTeamsItem>> getClubDiscover(){
        return listDiscoverClub;
    }
}
