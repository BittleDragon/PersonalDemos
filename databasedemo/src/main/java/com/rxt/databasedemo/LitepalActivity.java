package com.rxt.databasedemo;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rxt.databasedemo.models.Fruit;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;
import org.litepal.crud.callback.FindMultiCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LitepalActivity extends AppCompatActivity {

    @BindView(R.id.create)
    Button create;
    @BindView(R.id.insert)
    Button insert;
    @BindView(R.id.delete)
    Button delete;
    @BindView(R.id.update)
    Button update;
    @BindView(R.id.query)
    Button query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litepal);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.create, R.id.insert, R.id.delete, R.id.update, R.id.query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.create:
                SQLiteDatabase database = LitePal.getDatabase();
                break;
            case R.id.insert:
                insertData();
                break;
            case R.id.delete:
                deleteData();
                break;
            case R.id.update:
                updateData();
                break;
            case R.id.query:
                queryData();
                break;
        }
    }

    private void queryData() {
        DataSupport.where("origin like ?", "湖南%").order("id desc")
                .findAsync(Fruit.class).listen(new FindMultiCallback() {
            @Override
            public <T> void onFinish(List<T> t) {
                List<Fruit> fruits = (List<Fruit>) t;
                for (Fruit f : fruits) {
                    String name = f.getName();
                    double price = f.getPrice();
                    String origin = f.getOrigin();
                    Log.e("数据内容", name + "****" + price + "****" + origin);
                }
            }
        });
    }

    private void updateData() {
        Fruit updateFruit = DataSupport.find(Fruit.class, 9);
        updateFruit.setPrice(15.99d);
        updateFruit.save();
        Toast.makeText(this, "数据修改了", Toast.LENGTH_SHORT).show();
    }

    private void deleteData() {
        DataSupport.deleteAll(Fruit.class, "price = ?", "9.98");
        Toast.makeText(this, "数据删除了", Toast.LENGTH_SHORT).show();
    }

    private void insertData() {

        Fruit apple = new Fruit();
        apple.setName("苹果");
        apple.setPrice(5.99d);
        apple.setPriceUnit("¥/kg");
        apple.setOrigin("山东");
        apple.save();

        Fruit banana = new Fruit();
        banana.setName("香蕉");
        banana.setPrice(3.99d);
        banana.setPriceUnit("¥/kg");
        banana.setOrigin("海南");
        banana.save();

        Fruit pitaya = new Fruit();
        pitaya.setName("火龙果");
        pitaya.setPrice(6.98d);
        pitaya.setPriceUnit("¥/kg");
        pitaya.setOrigin("广东");
        pitaya.save();

        Fruit pineapple = new Fruit();
        pineapple.setName("菠萝");
        pineapple.setPrice(9.98d);
        pineapple.setPriceUnit("¥/kg");
        pineapple.setOrigin("海南");
        pineapple.save();

        Fruit litchi = new Fruit();
        litchi.setName("荔枝");
        litchi.setPrice(4.66d);
        litchi.setPriceUnit("¥/kg");
        litchi.setOrigin("广东");
        litchi.save();

        Fruit orange = new Fruit();
        orange.setName("柑橘");
        orange.setPrice(3.36d);
        orange.setPriceUnit("¥/kg");
        orange.setOrigin("湖南");
        orange.save();

        Toast.makeText(this, "数据保存了", Toast.LENGTH_SHORT).show();

    }
}
