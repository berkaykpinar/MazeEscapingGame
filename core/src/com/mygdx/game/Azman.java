package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Azman extends Actor {
    private static Sprite sprite = new Sprite(new Texture(Gdx.files.internal("azman.png")));
    private int[] distance;
    public static Dijkstra dijkstra;
    private static int x;
    private static int y;
    private String type= "düşman";
    Main main;

    public void setStartCoord(int[] startCoord) {
        sprite.setPosition(startCoord[0] * 60, startCoord[1] * 60);
        System.out.println("xxxxxxxxxx"+startCoord[0]+" yyyyyyyyyy"+startCoord[1]);
        this.x = startCoord[0];
        this.y = startCoord[1];
    }

    public void setDistance(int[] distance) {
        this.distance = distance;
    }


    public int[] getDistance() {
        return distance;
    }

    public Azman() {
        x=3;
        y=10;
        sprite.setSize(60, 60);
        sprite.setPosition(x * 60, y * 60);


        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        main = new Main();

    }

    public void move() {
        dijkstra = new Dijkstra(Main.GAME_MAP, (int) Main.oyuncu.sprite.getY() / 60
                , (int) Main.oyuncu.sprite.getX() / 60,
                (int) Main.azman.sprite.getY() / 60, (int) Main.azman.sprite.getX() / 60);

        if (!(Main.oyuncu.sprite.getY() / 60 == Main.azman.sprite.getY() / 60
                && Main.oyuncu.sprite.getX() / 60 == Main.azman.sprite.getX() / 60)) {
            sprite.setPosition(dijkstra.path()[2] * 60, dijkstra.path()[3] * 60);
        }


        if (Main.oyuncu.sprite.getY() / 60 == Main.azman.sprite.getY() / 60
                && Main.oyuncu.sprite.getX() / 60 == Main.azman.sprite.getX() / 60) {
            sprite.setPosition(x * 60, y * 60);
            Main.oyuncu.puan= Main.oyuncu.puan-5;
        }
        System.out.println("xxxxxxxxxx"+x+" yyyyyyyyyy"+y);

    }

    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(), getY());
        super.positionChanged();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch, 1f);

    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public int getStartCoord() {
        return x;
    }



}
