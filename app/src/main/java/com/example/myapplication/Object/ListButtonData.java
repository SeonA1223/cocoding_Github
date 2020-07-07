package com.example.myapplication.Object;

import java.util.ArrayList;

public class ListButtonData {

    private int listImage;
    private String listName;

    public void add(){
        this.listImage=getlistImage();
        this.listName=getlistName();
    }

    public String getlistName() {
        return listName;
    }

    public void setlistName(String listName) {
        this.listName = listName;
    }

    public int getlistImage() {
        return listImage;
    }

    public void setlistImage(int listImage) {
        this.listImage = listImage;
    }

}
