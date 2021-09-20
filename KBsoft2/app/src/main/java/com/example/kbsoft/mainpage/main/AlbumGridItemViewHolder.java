package com.example.kbsoft.mainpage.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kbsoft.R;

public class AlbumGridItemViewHolder {
    public ImageView ivPhoto;

    public TextView tvDate;

    public AlbumGridItemViewHolder(View a_view) {
        ivPhoto = a_view.findViewById(R.id.item_iv_photo);
        tvDate = a_view.findViewById(R.id.item_tv_date);
    }
}

