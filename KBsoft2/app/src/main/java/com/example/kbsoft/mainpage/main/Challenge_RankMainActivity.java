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

    }


    private void createData() {


    }
}
