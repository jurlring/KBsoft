package com.example.kbsoft.mainpage.main;

public class Challenge_GalleryItem {

    public Challenge_GalleryItem(int Num, String Uri) {
        num= Num;
        uri = Uri;
    }

    private int num;
    private String uri;

    public void setNum(int num){this.num = num;}
    public void setUri(String uri){this.uri = uri;}

    public int getNum(){return this.num;}
    public String getUri(){return this.uri;}
}
