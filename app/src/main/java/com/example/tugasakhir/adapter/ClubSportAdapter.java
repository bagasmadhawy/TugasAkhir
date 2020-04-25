package com.example.tugasakhir.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tugasakhir.R;
import com.example.tugasakhir.model.club.ClubTeamsItem;
import com.example.tugasakhir.view.activity.DetailClub;

import java.util.ArrayList;

public class ClubSportAdapter extends RecyclerView.Adapter<ClubSportAdapter.ViewHolder> {

    private ArrayList<ClubTeamsItem> clubTeamsItems = new ArrayList<>();
    private Context context;

    //private static String BASE_IMAGE_URL ="https://www.thesportsdb.com/images/media/team/badge/";

    public ClubSportAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<ClubTeamsItem> items){
        clubTeamsItems.clear();
        clubTeamsItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ClubSportAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubSportAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(clubTeamsItems.get(position).getStrTeamBadge()).into(holder.ivThumb);
        holder.tvTitle.setText(clubTeamsItems.get(position).getStrTeam());
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailClub.class);
                intent.putExtra("logo", clubTeamsItems.get(position).getStrTeamBadge());
                intent.putExtra("name", clubTeamsItems.get(position).getStrTeam());
                intent.putExtra("tahun", clubTeamsItems.get(position).getIntFormedYear());
                intent.putExtra("stadium", clubTeamsItems.get(position).getStrStadium());
                intent.putExtra("liga", clubTeamsItems.get(position).getStrLeague());
                intent.putExtra("website", clubTeamsItems.get(position).getStrWebsite());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return clubTeamsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivThumb;
        TextView tvTitle;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cv);
            ivThumb = itemView.findViewById(R.id.itemlist_iv_thumbnail);
            tvTitle = itemView.findViewById(R.id.itemlist_tv_title);
        }
    }
}
