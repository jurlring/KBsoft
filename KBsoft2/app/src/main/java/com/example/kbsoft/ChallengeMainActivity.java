package com.example.kbsoft;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kbsoft.mainpage.main.ChallengeAdapter;
import com.example.kbsoft.mainpage.main.ChallengeItem;

import java.util.ArrayList;

public class ChallengeMainActivity extends AppCompatActivity {

    ArrayList<ChallengeItem> challengeItems;
    ArrayList<ChallengeItem> searchItems;
    ChallengeAdapter challengeAdapter;
    private EditText search;
    ImageButton friendrank;
    ImageButton mainpage;
    ImageButton starpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challengemain);
        challengeItems=new ArrayList<>();
        searchItems=new ArrayList<>();
        search=(EditText)findViewById(R.id.search);
        friendrank=(ImageButton)findViewById(R.id.btn_friendrank);
        mainpage=(ImageButton)findViewById(R.id.btn_mainpage);
        starpage=(ImageButton)findViewById(R.id.btn_starpage);

        createData();

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_challenge);
        recyclerView.setHasFixedSize(true);
        challengeAdapter=new ChallengeAdapter(this,challengeItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(challengeAdapter);

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
}
