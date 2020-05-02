package com.example.tugasakhir.database;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasakhir.R;

import java.util.ArrayList;

public class TimAdapter extends RecyclerView.Adapter<TimAdapter.ViewHolder> {

    private Context context;
    private ArrayList<TimModel> timItems = new ArrayList<>();
    private AppDatabase appDatabase;

    public TimAdapter(Context context){
        this.context = context;
        appDatabase = AppDatabase.initDatabase(this.context);
    }

    public void setData(ArrayList<TimModel> items){
        timItems.clear();
        timItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TimAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_tim, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimAdapter.ViewHolder holder, final int position) {
        holder.namaPemain.setText(timItems.get(position).getNama());
        holder.tahunPemain.setText(timItems.get(position).getTahun());
        holder.timPemain.setText(timItems.get(position).getTim());
        holder.posisiPemain.setText(timItems.get(position).getPosisi());
        holder.negaraPemain.setText(timItems.get(position).getAsalNeg());

        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    TimModel timModel = new TimModel();

                    timModel.setNama(timItems.get(position).getNama());
                    timModel.setTahun(timItems.get(position).getTahun());
                    timModel.setTim(timItems.get(position).getTim());
                    timModel.setPosisi(timItems.get(position).getPosisi());
                    timModel.setAsalNeg(timItems.get(position).getAsalNeg());
                    timModel.setId(timItems.get(position).getId());

                    appDatabase.timDAO().deleteTim(timModel);

                    Log.d("TimAdapter", "Sukses Menghapus!");
                    Toast.makeText(context,"Berhasil Menghapus", Toast.LENGTH_SHORT).show();
                }catch(Exception ex){
                    Log.e("TimAdapter", "Gagal Menghapus, Msg = "+ex.getMessage());
                    Toast.makeText(context,"Gagal Menghapus", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return timItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btn_delete;
        TextView namaPemain, tahunPemain, timPemain, posisiPemain, negaraPemain;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            btn_delete = itemView.findViewById(R.id.btn_delete);
            namaPemain = itemView.findViewById(R.id.tv_namaPemain);
            tahunPemain = itemView.findViewById(R.id.tv_tahunPemain);
            timPemain = itemView.findViewById(R.id.tv_timPemain);
            posisiPemain = itemView.findViewById(R.id.tv_posisiPemain);
            negaraPemain = itemView.findViewById(R.id.tv_asalPemain);
        }
    }
}
