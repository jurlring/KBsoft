package com.example.kbsoft.mainpage.main;

public class RankItem {
    public String Friend;
    public String num;

    public RankItem(String friend, String num) {
        this.Friend = friend;
        this.num = num;
    }

    public String getFriend() { return Friend;
    }

    public void setFriend(String friend) {Friend = friend;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
