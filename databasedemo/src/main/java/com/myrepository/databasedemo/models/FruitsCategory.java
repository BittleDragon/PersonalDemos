package com.myrepository.databasedemo.models;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raoxuting on 2017/7/10.
 */

public class FruitsCategory extends DataSupport {

    private String categoryName;

    private int categoryId;

    private List<Fruit> fruitsBelongs = new ArrayList<>();

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<Fruit> getFruitsBelongs() {
        return fruitsBelongs;
    }

    public void setFruitsBelongs(List<Fruit> fruitsBelongs) {
        this.fruitsBelongs = fruitsBelongs;
    }
}
