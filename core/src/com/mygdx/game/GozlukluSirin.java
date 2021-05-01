package com.mygdx.game;

public class GozlukluSirin extends Oyuncu {
    private String name = "gozluklu";
    private int id= 1;
    private String type= "oyuncu";
    private int x;
    private int y;
    private int point =20;



    public GozlukluSirin(){
        x=5*30;
        y=5*30;
    }
    @Override
    public float getX() {
        return x;

    }
    @Override
    public float getY() {
        return y;

    }
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
