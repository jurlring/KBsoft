package com.example.kbsoft.mainpage.main;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kbsoft.R;

import java.util.ArrayList;

public class Challenge_RankAdaptor extends RecyclerView.Adapter<Challenge_RankAdaptor.RankViewHolder> {

    private ArrayList<Challenge_RankMainActivity> arrayList;
    private Context context;
    private ArrayList<RankItem> rankItems;


    public Challenge_RankAdaptor(ArrayList<Challenge_RankMainActivity> arrayList) {
        this.arrayList = arrayList;
        this.rankItems = rankItems;
    }



    @NonNull
    @Override
    public Challenge_RankAdaptor.RankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_challengerankmain, parent,false);
        RankViewHolder holder = new RankViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RankViewHolder holder, int position) {

        RankItem rankItem=rankItems.get(position);
        holder.friend.setText(rankItem.getFriend());
        holder.num.setText(rankItem.getNum());
        holder.magnitude.setText((CharSequence) arrayList.get(position));
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String curName = holder.friend.getText().toString();
                Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void filderList(ArrayList<RankItem> searchItems) {
        rankItems=searchItems;
        notifyDataSetChanged();
    }

    public class RankViewHolder extends RecyclerView.ViewHolder {


        protected TextView magnitude;
        protected ImageButton btn_friendrank_rank;
        protected TextView friend;
        protected TextView num;

        public RankViewHolder(@NonNull View itemView) {
            super(itemView);
            this.magnitude = (TextView)itemView.findViewById(R.id.magnitude);
            this.btn_friendrank_rank = (ImageButton) itemView.findViewById(R.id.btn_friendrank_rank);
            this.friend = (TextView)itemView.findViewById(R.id.friend);
            this.num = (TextView)itemView.findViewById(R.id.num);

        }
    }
}
