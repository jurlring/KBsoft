package com.example.kbsoft.mainpage.main;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.kbsoft.R;

import java.util.ArrayList;

import gun0912.tedbottompicker.TedBottomPicker;

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.ItemRowHolder> {

    private ArrayList<ChallengeItem> challengeItems;
    private Context context;
    private PhotoCallbackListener photoCallbackListener;
    int set;

    //mainActivity에서 전달 받은 콜백메서드를 setter
    public void setPhotoCallbackListener(PhotoCallbackListener photoCallbackListener) {
        this.photoCallbackListener = photoCallbackListener;
    }

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
        setPhotoCallbackListener(photoCallbackListener);

        //start버튼 눌렀을 때 사진 저장
        holder.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoCallbackListener.callBack(0,position);
                set=0;
            }
        });
        //rank버튼 눌렀을 때 rank엑티비티로 intent
        holder.rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoCallbackListener.callBack(1,position);
                set=1;
            }
        });
        //photo버튼 눌렀을 때 photo엑티비티로 intent
        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                photoCallbackListener.callBack(2,position);
                set=2;
            }
        });
        holder.bind(photoCallbackListener);
    }

    @Override
    public int getItemCount() {
        return null!= challengeItems ? challengeItems.size():0;
    }

    public void filderList(ArrayList<ChallengeItem> searchItems) {
        challengeItems=searchItems;
        notifyDataSetChanged();
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        protected TextView challenge;
        protected TextView num;
        protected Button start;
        protected Button rank;
        protected Button photo;
        private PhotoCallbackListener photoCallbackListener;

        public ItemRowHolder(View itemView) {
            super(itemView);
            this.challenge=(TextView)itemView.findViewById(R.id.challenge);
            this.num=(TextView)itemView.findViewById(R.id.num);
            this.start=(Button)itemView.findViewById(R.id.btn_start);
            this.rank=(Button)itemView.findViewById(R.id.btn_rank);
            this.photo=(Button)itemView.findViewById(R.id.btn_photo);
            itemView.setOnClickListener(this);
        }

        public void bind(PhotoCallbackListener photoCallbackListener) {
            this.photoCallbackListener=photoCallbackListener;
        }

        @Override
        public void onClick(View v) {
            int id=getPosition();
            setPhotoCallbackListener(photoCallbackListener);
            if (id>=0&&id<=6)
                photoCallbackListener.callBack(set,id);
        }
    }
}
