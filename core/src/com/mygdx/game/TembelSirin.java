package com.mygdx.game;


public class TembelSirin extends Oyuncu {
    private String name = "tembel";
    private int id= 2;
    private String type= "oyuncu";
    private int x;
    private int y;
    private int point =20;



    public TembelSirin(){
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
