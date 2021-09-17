package com.example.kbsoft.mainpage.main;



import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kbsoft.ChallengeMainActivity;
import com.example.kbsoft.R;

public class Challenge_RankMainActivity extends AppCompatActivity {

    private EditText search;
    private ImageButton friendrank;
    private ImageButton mainpage;
    private ImageButton starpage;
    private TextView challenge_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challengerankmain);

        Intent intent=getIntent();
        String Challenge_Name=intent.getStringExtra("Challenge_Name");

        challenge_name=(TextView)findViewById(R.id.challenge_name);
        search=(EditText)findViewById(R.id.search_rank);
        friendrank=(ImageButton)findViewById(R.id.btn_friendrank_rank);
        mainpage=(ImageButton)findViewById(R.id.btn_mainpage_rank);
        starpage=(ImageButton)findViewById(R.id.btn_starpage_rank);

        challenge_name.setText(Challenge_Name);

        createData();

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_challenge_rank);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

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
                Intent Intent = new Intent(Challenge_RankMainActivity.this, ChallengeMainActivity.class);
                Toast.makeText(Challenge_RankMainActivity.this, "챌린지 페이지로 이동", Toast.LENGTH_SHORT).show();
                startActivity(Intent);
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
                //search(text);
            }


        });
    }
    /*
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
    */

    private void createData() {


    }
}
