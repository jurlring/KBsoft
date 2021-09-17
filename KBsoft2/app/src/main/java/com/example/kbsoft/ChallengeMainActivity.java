package com.example.kbsoft;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kbsoft.mainpage.main.ChallengeAdapter;
import com.example.kbsoft.mainpage.main.ChallengeItem;
import com.example.kbsoft.mainpage.main.Challenge_RankMainActivity;
import com.example.kbsoft.mainpage.main.PhotoCallbackListener;

import java.util.ArrayList;

import gun0912.tedbottompicker.TedBottomPicker;

public class ChallengeMainActivity extends AppCompatActivity {

    ArrayList<ChallengeItem> challengeItems;
    ArrayList<ChallengeItem> searchItems;
    ChallengeAdapter challengeAdapter;
    private EditText search;
    ImageButton friendrank;
    ImageButton mainpage;
    ImageButton starpage;
    //권한 설정
    final static int PERMISSION_REQUEST_CODE = 1000;

    private PhotoCallbackListener photoCallbackListener=new PhotoCallbackListener() {
        @Override
        public void callBack(int set,int pos) {
            if (set == 0) {
                if (pos >= 0 && pos <= 6) {
                    TedBottomPicker bottomSheetDialogFragment = new TedBottomPicker.Builder(ChallengeMainActivity.this)
                            .setOnImageSelectedListener(new TedBottomPicker.OnImageSelectedListener() {
                                @Override
                                public void onImageSelected(Uri uri) {
                                    insertPhoto(pos, uri);
                                }

                            })
                            .create();

                    bottomSheetDialogFragment.show(getSupportFragmentManager());
                }
            }
            else if (set==1){
                Intent Intent = new Intent(ChallengeMainActivity.this, Challenge_RankMainActivity.class);
                Intent.putExtra("Challenge_Name",challengeItems.get(pos).getChallenge());
                Toast.makeText(ChallengeMainActivity.this, "챌린지 랭크로 이동", Toast.LENGTH_SHORT).show();
                startActivity(Intent);
            }
            else if (set==2){
                //Intent menuIntent = new Intent(Challenge_RankMainActivity.this, ChallengeMainActivity.class);
                //Toast.makeText(Challenge_RankMainActivity.this, "앨범 전체보기 클릭", Toast.LENGTH_SHORT).show();
                //startActivity(menuIntent);

            }
        }
    };

    private void insertPhoto(int pos,Uri uri) {
        DBPhotoHelper dbPhotoHelper=new DBPhotoHelper(this);
        dbPhotoHelper.insertPhoto(pos,uri.toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challengemain);

        permissionCheck();//권한 체크

        challengeItems=new ArrayList<>();
        searchItems=new ArrayList<>();
        search=(EditText)findViewById(R.id.search_main);
        friendrank=(ImageButton)findViewById(R.id.btn_friendrank_main);
        mainpage=(ImageButton)findViewById(R.id.btn_mainpage_main);
        starpage=(ImageButton)findViewById(R.id.btn_starpage_main);

        createData();

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_challenge);
        recyclerView.setHasFixedSize(true);
        challengeAdapter=new ChallengeAdapter(this,challengeItems);
        challengeAdapter.setPhotoCallbackListener(photoCallbackListener);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(challengeAdapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //친구랭킹으로 이동
        friendrank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //메인페이지로 이동
        mainpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //star페이지로 이동
        starpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //검색창 구현
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {//text치고 난 후
                String text = search.getText().toString();
                search(text);
            }


        });
    }
    public void search(String text) {
        searchItems.clear();
        if (text.length()==0){
            searchItems.addAll(challengeItems);
        }
        else {
            for(int i=0;i<challengeItems.size();i++){
                if (challengeItems.get(i).getChallenge().toLowerCase().contains(text)){
                    searchItems.add(challengeItems.get(i));
                }
            }
        }
        challengeAdapter.filderList(searchItems);
    }

    private void createData() {
        ChallengeItem a=new ChallengeItem("분리수거 Challenge","0/10");
        ChallengeItem b=new ChallengeItem("텀블러 사용 Challenge","0/10");
        ChallengeItem c=new ChallengeItem("바닥에 떨어진 쓰레기 줍기 Challenge","0/10");
        ChallengeItem d=new ChallengeItem("외식할 때 내 용기 쓰기 Challenge","0/10");
        ChallengeItem e=new ChallengeItem("만보 걷기 Challenge","0/10");
        ChallengeItem f=new ChallengeItem("장바구니 이용하기 Challenge","0/10");
        ChallengeItem g=new ChallengeItem("안 쓰는 플러그 뽑기 Challenge","0/10");
        challengeItems.add(a);
        challengeItems.add(b);
        challengeItems.add(c);
        challengeItems.add(d);
        challengeItems.add(e);
        challengeItems.add(f);
        challengeItems.add(g);

    }
    //권한 체크 함수
    private void permissionCheck() {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
            ArrayList<String> arrayPermission = new ArrayList<String>();

            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                arrayPermission.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            }

            permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                arrayPermission.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }

            if (arrayPermission.size() > 0) {
                String strArray[] = new String[arrayPermission.size()];
                strArray = arrayPermission.toArray(strArray);
                ActivityCompat.requestPermissions(this, strArray, PERMISSION_REQUEST_CODE);
            } else {
                // Initialize 코드
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode) {
            case PERMISSION_REQUEST_CODE: {
                if (grantResults.length < 1) {
                    Toast.makeText(this, "Failed get permission", Toast.LENGTH_SHORT).show();
                    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                    return ;
                }

                for (int i=0; i<grantResults.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "Permission is denied : " + permissions[i], Toast.LENGTH_SHORT).show();
                        finish();
                        return ;
                    }
                }

                Toast.makeText(this, "Permission is granted", Toast.LENGTH_SHORT).show();
                // Initialize 코드
            }
            break;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
