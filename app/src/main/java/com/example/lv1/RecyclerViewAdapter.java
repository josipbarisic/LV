package com.example.lv1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<Object> dataList;
    String title = "Studenti";
    private static final int HEADER = -1;
    private static final int LIST_ITEM = -2;

    public RecyclerViewAdapter(List<Object> myDataset) {

        dataList = myDataset;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item, parent, false);
        myViewHolder holder = new myViewHolder(view, viewType);

        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        myViewHolder myVH = (myViewHolder)holder;
        if(getItemViewType(position) == LIST_ITEM)
        {
            myVH.tvImePrezime.setText(((Student) dataList.get(position)).sIme + " " + ((Student) dataList.get(position)).sPrezime);
            myVH.tvPredmet.setText(((Student)dataList.get(position)).sPredmet);
        }
        else {
            myVH.tvTitle.setText(dataList.get(position).toString());
        }
    }

    @Override
    public int getItemCount() {

        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(dataList.get(position) instanceof Student){
            return LIST_ITEM;
        }
        return HEADER;
//        return super.getItemViewType(position);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        TextView tvImePrezime;
        TextView tvPredmet;
        TextView tvTitle;

        public myViewHolder(@NonNull View itemView, int viewType) {
            super(itemView);

            if(viewType == HEADER){
                tvTitle = itemView.findViewById(R.id.tvTitle);
            }
            else{
                tvImePrezime = itemView.findViewById(R.id.tvImePrezime);
                tvPredmet = itemView.findViewById(R.id.tvImePredmeta);
            }
        }
    }
}