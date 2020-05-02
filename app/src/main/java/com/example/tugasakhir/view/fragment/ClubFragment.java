package com.example.tugasakhir.view.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasakhir.R;
import com.example.tugasakhir.adapter.ClubSportAdapter;
import com.example.tugasakhir.model.club.ClubTeamsItem;
import com.example.tugasakhir.view.viewmodel.ClubViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class  ClubFragment extends Fragment {

    private ClubSportAdapter clubSportAdapter;
    private RecyclerView rvClub;
    private ClubViewModel clubViewModel;

    public ClubFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_club, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        clubSportAdapter = new ClubSportAdapter(getContext());
        clubSportAdapter.notifyDataSetChanged();

        rvClub = view.findViewById(R.id.fragmentclub_rv);
        rvClub.setLayoutManager(new GridLayoutManager(getContext(), 2));

        clubViewModel = new ViewModelProvider(this).get(ClubViewModel.class);
        clubViewModel.setClubDiscover();
        clubViewModel.getClubDiscover().observe(this, getClubDiscover);

        rvClub.setAdapter(clubSportAdapter);
    }

    private Observer<ArrayList<ClubTeamsItem>> getClubDiscover = new Observer<ArrayList<ClubTeamsItem>>() {
        @Override
        public void onChanged(ArrayList<ClubTeamsItem> clubTeamsItems) {
            if (clubTeamsItems != null){
                clubSportAdapter.setData(clubTeamsItems);
            }
        }
    };
}
