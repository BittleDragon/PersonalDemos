package com.rxt.databasedemo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.create_db)
    Button createDb;
    @BindView(R.id.add_data)
    Button addData;
    @BindView(R.id.delete_data)
    Button deleteData;
    @BindView(R.id.update_data)
    Button updateData;
    @BindView(R.id.query_data)
    Button queryData;
    @BindView(R.id.litepalActivity)
    Button litepal;
    private DatabaseHelper helper;
    private SQLiteDatabase bookstoreDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        helper = new DatabaseHelper(this, "BookStore.db", null, 3);
//        bookstoreDB = helper.getWritableDatabase();
    }

    @OnClick({R.id.create_db, R.id.add_data,R.id.delete_data, R.id.update_data, R.id.query_data,
            R.id.litepalActivity})
    public void onViewClicked(View view) {
        bookstoreDB = helper.getWritableDatabase();
        switch (view.getId()) {
            case R.id.create_db:
                break;
            case R.id.add_data:
                insertData();
                break;
            case R.id.delete_data:
                deleteData();
                break;
            case R.id.update_data:
                updateData();
                break;
            case R.id.query_data:
                queryData();
                break;
            case R.id.litepalActivity:
                startActivity(new Intent(this, LitepalActivity.class));
                break;
        }
        bookstoreDB.close();
    }

    private void insertData() {
        ContentValues values = new ContentValues();
        values.put("name", "鲁冰逊漂流记");
        values.put("price", 99.8);
        bookstoreDB.insert("book", null, values);

        values.clear();
        values.put("name", "三国演义");
        values.put("price", 299.66);
        bookstoreDB.insert("book", null, values);

        values.clear();
        values.put("name", "三国演义");
        values.put("price", 311.22);
        bookstoreDB.insert("book", null, values);

        values.clear();
        values.put("name", "三国演义");
        values.put("price", 188.88);
        bookstoreDB.insert("book", null, values);

        values.clear();
        values.put("name", "红楼梦");
        values.put("price", 400.98);
        bookstoreDB.insert("book", null, values);

        values.clear();
        values.put("name", "水浒传");
        values.put("price", 366);
        bookstoreDB.insert("book", null, values);

        values.clear();
        values.put("name", "资治通鉴");
        values.put("price", 666);
        bookstoreDB.insert("book", null, values);values.clear();

        values.clear();
        values.put("name", "资治通鉴");
        values.put("price", 888);
        bookstoreDB.insert("book", null, values);

    }

    private void deleteData() {
        bookstoreDB.delete("book", null, null);
    }

    private void updateData() {
        ContentValues values = new ContentValues();
        values.put("price", 888);
        bookstoreDB.update("book", values, "name like ?", new String[]{"红楼梦"});
    }

    private void queryData() {
        Cursor cusor = bookstoreDB.query("book", null, null,null,
                "name", "count(name) < 2", "name asc");
        if (cusor.moveToFirst()) {
            do {
                int id = cusor.getInt(cusor.getColumnIndex("id"));
                String name = cusor.getString(cusor.getColumnIndex("name"));
                double price = cusor.getDouble(cusor.getColumnIndex("price"));
//                Log.e("书名和价格", name + "******" + price);
//                Log.e("价格", price + "");
                Log.e("数据内容", id + "****" + name + "****" + price);
            } while (cusor.moveToNext());
        }
        cusor.close();
    }
}
