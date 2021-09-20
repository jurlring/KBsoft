package com.example.kbsoft.mainpage.main;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kbsoft.DBPhotoHelper;
import com.example.kbsoft.R;
import java.util.ArrayList;

public class Challenge_GalleryMainActivity extends AppCompatActivity {

    GridView gvList;
    Challenge_GalleryAdapter adapter;
    TextView textname;
    int challenge;


    public Context setContext(){
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challengegallery);


        //Intent tag 처리
        Intent secondIntent = getIntent();
        String tag = secondIntent.getExtras().getString("Challenge_Name");
        challenge=secondIntent.getExtras().getInt("Challenge_Number");
        textname = findViewById(R.id.challenge_name_gallery);
        textname.setText(tag);
        gvList = findViewById(R.id.gridView);

        displayList(challenge);

        DBPhotoHelper helper = new DBPhotoHelper(this);

        gvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getApplicationContext(),"Index : "+ adapter.getItemId(i),Toast.LENGTH_LONG).show();
            }
        });
        gvList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long uid) {
                AlertDialog.Builder builder = new AlertDialog.Builder(setContext());
                builder.setTitle("삭제 확인");
                builder.setMessage("삭제하시겠습니까?");

                builder.setNegativeButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //삭제하기 전에 휴지통에 추가
                        helper.deletePhoto(uid);

                        Toast.makeText(getApplicationContext(), uid + "번째 아이템이 삭제되었습니다", Toast.LENGTH_SHORT).show();
                        displayList(challenge);
                        Toast.makeText(getApplicationContext(), "삭제됨", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setPositiveButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "삭제 취소됨", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
                return false;
            }
        });
    }
    public void displayList (int challenge){
        DBPhotoHelper helper = new DBPhotoHelper(this);
        SQLiteDatabase database = helper.getReadableDatabase();

        //Cursor에 목록을 담아주기
        Cursor cursor = database.rawQuery("SELECT * FROM photo",null);
        //Cursor cursor = database.rawQuery("SELECT * FROM photo WHERE challenge = "+challenge,null);

        ArrayList<Challenge_GalleryItem> dbList = new ArrayList<>();

        //목록의 개수만큼 순회하여 adapter에 있는 list배열에 add
        while (cursor.moveToNext()) {
            dbList.add(new Challenge_GalleryItem(cursor.getInt(0),  cursor.getString(2)));
            //adapter.addItemToList(cursor.getInt(1),cursor.getString(2),cursor.getString(3));
        }
        adapter = new Challenge_GalleryAdapter(this, dbList);
        //리스트뷰의 어댑터 대상을 여태 설계한 adapter로 설정
        gvList.setAdapter(adapter);
    }
}
