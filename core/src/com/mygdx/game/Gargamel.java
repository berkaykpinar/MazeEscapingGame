package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Gargamel extends Actor {
    public static boolean move=false;
    private static Sprite sprite = new Sprite(new Texture(Gdx.files.internal("gargamel.png")));

    private int[] distance;
    private int BIRIM_KARE=30;
    private ShapeRenderer shapeRenderer;
    private static int[] startCoord={10,10};
    public static Dijkstra dijkstra;
    private String type= "düşman";


    public void setDistance(int[] distance) {
        this.distance = distance;
    }


    public int[] getDistance() {
        return distance;
    }

    public Gargamel(){
        sprite.setSize(60,60);
        sprite.setPosition(startCoord[0] * 60, startCoord[1] * 60);


        setBounds(sprite.getX(),sprite.getY(),sprite.getWidth(),sprite.getHeight());
        shapeRenderer= new ShapeRenderer();


    }

    public void move(){
        dijkstra = new Dijkstra(Main.GAME_MAP,(int) Main.oyuncu.sprite.getY()/60
                ,(int) Main.oyuncu.sprite.getX()/60,
                (int) Main.gargamel.sprite.getY()/60,(int) Main.gargamel.sprite.getX()/60);

        if(!(Main.oyuncu.sprite.getY()/60== Main.gargamel.sprite.getY()/60
                && Main.oyuncu.sprite.getX()/60 == Main.gargamel.sprite.getX()/60)) {
            sprite.setPosition(  dijkstra.path()[2]*60,   dijkstra.path()[3]*60);

        }


      if(Main.oyuncu.sprite.getY()/60== Main.gargamel.sprite.getY()/60
                && Main.oyuncu.sprite.getX()/60 == Main.gargamel.sprite.getX()/60) {
            sprite.setPosition(startCoord[0] * 60, startCoord[1] * 60);
            Main.oyuncu.puan= Main.oyuncu.puan-15;
        }
        System.out.println("GARFAMEl"+dijkstra.path().length);

    }

    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(),getY());
        super.positionChanged();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch,1f);





        if(move==true){
            batch.end();

            shapeRenderer.setAutoShapeType(true);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(Color.ORANGE);
//            shapeRenderer.rect(distance[0]*150,distance[1]*30,60,60);

            shapeRenderer.end();

            batch.begin();
        }



    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public int[] getStartCoord() {
        return startCoord;
    }

    public void setStartCoord(int[] startCoord) {
        sprite.setPosition(startCoord[0] * 60, startCoord[1] * 60);
        this.startCoord = startCoord;
    }


}



