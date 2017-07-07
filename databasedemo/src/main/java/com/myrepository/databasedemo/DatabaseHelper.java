package com.myrepository.databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * 数据库操作对象
 * Created by raoxuting on 2017/7/7.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String Create_db = "create table book (" +
            "id integer primary key autoincrement, " +
            "name text, " +
            "price real)";

    public static final String Create_CategoryDb = "create table category (" +
            "id integer primary key autoincrement, " +
            "category_name text, " +
            "code integer)";
    private Context context;

    public DatabaseHelper(Context context, String name,
                          SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_db);
        db.execSQL(Create_CategoryDb);
        Toast.makeText(context, "数据库建表成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists book");
        db.execSQL("drop table if exists category");
        onCreate(db);
        Toast.makeText(context, "数据库更新成功", Toast.LENGTH_SHORT).show();
    }
}
