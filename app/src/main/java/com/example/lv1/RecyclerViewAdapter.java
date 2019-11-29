package com.example.lv1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<Student> dataList;
    //String title = "Studenti";

    public RecyclerViewAdapter(List<Student> myDataset) {
        //dataList.add(title);
        dataList = myDataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item, parent, false);
        studentViewHolder holder = new studentViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        studentViewHolder myVH = (studentViewHolder)holder;
        myVH.tvImePrezime.setText(dataList.get(position).sIme + " " + dataList.get(position).sPrezime);
        myVH.tvPredmet.setText(dataList.get(position).sPredmet);
    }

    @Override
    public int getItemCount() {

        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        /*if(dataList.get(position) instanceof Student){
            return super.getItemViewType(position);
        }*/
        return super.getItemViewType(position);
    }

    public class studentViewHolder extends RecyclerView.ViewHolder {

        TextView tvImePrezime;
        TextView tvPredmet;

        public studentViewHolder(@NonNull View itemView) {
            super(itemView);

            tvImePrezime = itemView.findViewById(R.id.tvImePrezime);
            tvPredmet = itemView.findViewById(R.id.tvImePredmeta);
        }
    }

    /*public class TitleViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;

        public TitleViewHolder(View item){
            super(item);

            tvTitle =
        }
    }*/
}
