package com.example.kbsoft;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.util.Date;

public class DBPhotoHelper extends SQLiteOpenHelper {

    final static String DB_NAME="data_photo.db";
    final static int DB_VERSION=1;
    public DBPhotoHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="CREATE TABLE photo(num INTEGER PRIMARY KEY AUTOINCREMENT,user VARCHAR(40) NOT NULL,challenge INTEGER NOT NULL,uri TEXT NOT NULL)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry = "DROP TABLE IF EXISTS photo";
        db.execSQL(qry);
        onCreate(db);
    }

    public void insertPhoto(int pos,String uri) {
        SQLiteDatabase db=getWritableDatabase();
        String qry="INSERT INTO photo(user,challenge,uri) VALUES('jurl','"+pos+"','"+uri+"')";
        db.execSQL(qry);
        db.close();
    }

    public void deletePhoto(long uid) {
        SQLiteDatabase db=getReadableDatabase();
        db.execSQL("DELETE FROM photo WHERE num="+uid);
        db.close();
    }
}
