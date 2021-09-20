package com.example.kbsoft.mainpage.main;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.kbsoft.R;

import java.util.List;

public class Challenge_GalleryAdapter extends ArrayAdapter<Challenge_GalleryItem> {
    private Context mContext;
    private List<Challenge_GalleryItem> itemList;
    private static final int LAYOUT_RESOURCE_ID = R.layout.item_challengegallery;


    public Challenge_GalleryAdapter(Context a_context, List<Challenge_GalleryItem> a_itemList) {
        super(a_context, LAYOUT_RESOURCE_ID, a_itemList);

        mContext = a_context;
        itemList = a_itemList;
    }
    @Override
    public int getCount() {
        return itemList.size(); //배열의 크기를 반환
    }
    @Override
    public long getItemId(int position) {
        Challenge_GalleryItem photo = itemList.get(position);
        return photo.getNum();
    }

    @Override
    public View getView(int a_position, View a_convertView, ViewGroup a_parent) {
        AlbumGridItemViewHolder viewHolder;
        if (a_convertView == null) {
            a_convertView = LayoutInflater.from(mContext).inflate(LAYOUT_RESOURCE_ID, a_parent, false);

            viewHolder = new AlbumGridItemViewHolder(a_convertView);
            a_convertView.setTag(viewHolder);
        } else {
            viewHolder = (AlbumGridItemViewHolder) a_convertView.getTag();
        }

        final Challenge_GalleryItem countryItem = itemList.get(a_position);

        // Photo 설정
        viewHolder.ivPhoto.setImageURI(Uri.parse(countryItem.getUri()));
        // Num 설정
        String num="";
        num+=countryItem.getNum();
        viewHolder.tvDate.setText(num);
        return a_convertView;
    }
}
