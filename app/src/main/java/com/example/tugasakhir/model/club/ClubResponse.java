package com.example.tugasakhir.model.club;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ClubResponse{

	@SerializedName("teams")
	private ArrayList<ClubTeamsItem> teams;

	public void setTeams(ArrayList<ClubTeamsItem> teams){
		this.teams = teams;
	}

	public ArrayList<ClubTeamsItem> getTeams(){
		return teams;
	}

	@Override
 	public String toString(){
		return 
			"ClubResponse{" + 
			"teams = '" + teams + '\'' + 
			"}";
		}
}