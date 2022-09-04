package com.example.foododering;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table Userdetails(name TEXT, contanct TEXT primary key not null, address TEXT, email TEXT, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop Table if exists Userdetails");

    }

    public Boolean InsertData(String name, String contact, String address, String email, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);
        contentValues.put("address", address);
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = myDB.insert("Userdetails", null, contentValues);

        if(result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkname(String name) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from Userdetails where name = ?", new String[]{name});
        if(cursor.getCount()>0) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkcontact(String contact) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from Userdetails where contact = ?", new String[]{contact});
        if(cursor.getCount()>0) {
            return true;
        } else {
            return false;
        }
    }
//
//    public Boolean checkaddress(String address) {
//        SQLiteDatabase myDB = this.getWritableDatabase();
//        Cursor cursor = myDB.rawQuery("select * from Userdetails where address = ?", new String[]{address});
//        if(cursor.getCount()>0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public Boolean checkemail(String email) {
//        SQLiteDatabase myDB = this.getWritableDatabase();
//        Cursor cursor = myDB.rawQuery("select * from Userdetails where email = ?", new String[]{email});
//        if(cursor.getCount()>0) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public Boolean checkusernameandpassword(String name, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("select * from Userdetails where name = ? and password = ?", new String[]{name, password});
        if(cursor.getCount()>0) {
            return true;
        } else {
            return false;
        }
    }
}
