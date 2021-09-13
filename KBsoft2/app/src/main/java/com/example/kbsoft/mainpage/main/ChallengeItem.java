package com.example.kbsoft.mainpage.main;


public class ChallengeItem {

    public String Challenge;
    public String num;

    public ChallengeItem(String challenge, String num) {
        Challenge = challenge;
        this.num = num;
    }

    public String getChallenge() {
        return Challenge;
    }

    public void setChallenge(String challenge) {
        Challenge = challenge;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
