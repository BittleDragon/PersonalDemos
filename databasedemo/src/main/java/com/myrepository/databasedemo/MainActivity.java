package com.myrepository.databasedemo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        helper = new DatabaseHelper(this, "BookStore.db", null, 2);
    }

    @OnClick({R.id.create_db, R.id.add_data})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.create_db:
                helper.getReadableDatabase();
                break;
            case R.id.add_data:
                insertData();
                break;
        }
    }

    private void insertData() {
        SQLiteDatabase bookstoreDB = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "鲁冰逊漂流记");
        values.put("price", 99.8);
        bookstoreDB.insert("book", null, values);

        values.clear();
        values.put("name", "三国演义");
        values.put("price", 299.66);
        bookstoreDB.insert("book", null, values);

        values.clear();
        values.put("name", "红楼梦");
        values.put("price", 400.98);
        bookstoreDB.insert("book", null, values);
    }
}
