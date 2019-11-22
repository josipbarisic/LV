package com.example.lv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private ArrayList<String> student = new ArrayList<>();
    private ArrayList<String> predmet = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> student, ArrayList<String> predmet) {
        this.mContext = mContext;
        this.student = student;
        this.predmet = predmet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvImePrezime.setText(student.get(position));
        holder.tvImePredmeta.setText(predmet.get(position));
    }

    @Override
    public int getItemCount() {
        return student.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvImePrezime;
        TextView tvImePredmeta;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvImePrezime = itemView.findViewById(R.id.tvImePrezime);
            tvImePredmeta = itemView.findViewById(R.id.tvImePredmeta);
            parentLayout = itemView.findViewById(R.id.parent_layout);


        }
    }
}
