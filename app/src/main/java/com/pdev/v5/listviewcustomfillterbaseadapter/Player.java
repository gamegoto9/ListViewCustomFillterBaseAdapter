package com.pdev.v5.listviewcustomfillterbaseadapter;

/**
 * Created by v5 on 2/6/2559.
 */
public class Player {
    private String name;
    private int img;

    public Player(String name,int img){
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
