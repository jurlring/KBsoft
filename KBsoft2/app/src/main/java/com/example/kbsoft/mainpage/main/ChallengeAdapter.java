package com.example.kbsoft.mainpage.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.kbsoft.R;

import java.util.ArrayList;

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.ItemRowHolder> {

    private ArrayList<ChallengeItem> challengeItems;
    private Context context;

    public ChallengeAdapter(Context context, ArrayList<ChallengeItem> challengeItems) {
        this.context=context;
        this.challengeItems=challengeItems;
    }


    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_challenge, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder holder, int position) {
        ChallengeItem challengeItem=challengeItems.get(position);
        holder.challenge.setText(challengeItem.getChallenge());
        holder.num.setText(challengeItem.getNum());
        //start버튼 눌렀을 때 사진 저장
        holder.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //rank버튼 눌렀을 때 rank엑티비티로 intent
        holder.rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //photo버튼 눌렀을 때 photo엑티비티로 intent
        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return null!= challengeItems ? challengeItems.size():0;
    }

    public void filderList(ArrayList<ChallengeItem> searchItems) {
        challengeItems=searchItems;
        notifyDataSetChanged();
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView challenge;
        protected TextView num;
        protected Button start;
        protected Button rank;
        protected Button photo;

        public ItemRowHolder(View itemView) {
            super(itemView);
            this.challenge=(TextView)itemView.findViewById(R.id.challenge);
            this.num=(TextView)itemView.findViewById(R.id.num);
            this.start=(Button)itemView.findViewById(R.id.btn_start);
            this.rank=(Button)itemView.findViewById(R.id.btn_rank);
            this.photo=(Button)itemView.findViewById(R.id.btn_photo);
        }
    }
}
