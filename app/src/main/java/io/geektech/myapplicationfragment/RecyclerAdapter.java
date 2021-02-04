package io.geektech.myapplicationfragment;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private ArrayList<MainModel> list;
    private Context context;
    private IFragments listener;

    public RecyclerAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.onBind(list.get(position), position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtTitle;
        private ImageView imgView;
        private TextView txtSubTitle;
        private MainModel model;
        int pos;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTitle = itemView.findViewById(R.id.tvTitle);
            txtSubTitle = itemView.findViewById(R.id.tvDesc);
            imgView = itemView.findViewById(R.id.imgView);
        }

        private void onBind(MainModel model, int pos) {
            this.model = model;
            this.pos = pos;
            txtTitle.setText(model.getTitle());
            txtSubTitle.setText(model.getSubTitle());
            imgView.setImageResource(model.getImage());
        }

        @Override
        public void onClick(View view) {
            if (listener != null ) {
                listener.displayDetails(model.getTitle(), model.getSubTitle(), model.getImage());
            }
        }
    }

    public void setOnClickListener(IFragments mListener) {
        this.listener = mListener;
    }

}
