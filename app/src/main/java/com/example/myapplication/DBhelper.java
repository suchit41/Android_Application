package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public DBhelper(@Nullable Context context) {
        super(context, "signup",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create Table  signuppage(Name Text primary key ,Email Text ,Contact Text,Password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("drop Table if exists signuppage ");
    }
    public Boolean insertuserdata(String Name ,String Email,String Contact ,String Password){
SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",Name);
        contentValues.put("Email",Email);
        contentValues.put("Contact",Contact);
        contentValues.put("Password",Password);
        Long result = db.insert("signuppage",null,contentValues);
        if (result==-1){
            return false;
        }else{
            return true;
        }

    }
    public Boolean updateuserdata(String Name ,String Email,String Contact ,String Password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Email",Email);
        contentValues.put("Contact",Contact);
        contentValues.put("Password",Password);
        Cursor cursor= db.rawQuery("select * from signuppage where Name = ? ",new String[]{Name});
        if (cursor.getCount()>0){
        Long result = Long.valueOf(db.update("signuppage",contentValues,"Name=?", new String[] {Name}));
        if (result==-1){
            return false;
        }else{
            return true;
        }
        }else {
            return false;
            }}
        public Boolean deleteuserdata(String Name ,String Email,String Contact ,String Password){
            SQLiteDatabase db = this.getWritableDatabase();

            Cursor cursor= db.rawQuery("select * from signuppage where Name = ? ",new String[]{Name});
            if (cursor.getCount()>0){
                Long result = Long.valueOf(db.delete("signuppage","Name=?", new String[] {Name}));
                if (result==-1){
                    return false;
                }else{
                    return true;
                }
            }else {
                return false;
            }}

            public Cursor getdata() {
                SQLiteDatabase db = this.getWritableDatabase();

                Cursor cursor = db.rawQuery("select * from signuppage where Name = ? ", null);
                return cursor;
            }
}
