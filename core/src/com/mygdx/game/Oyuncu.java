package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import java.util.Scanner;

public class Oyuncu extends Actor {
    Sprite sprite;
    Sprite sprite1 = new Sprite(new Texture(Gdx.files.internal("sirine.png")));
    public static int puan = 20;
    public int name;

    Gargamel gargamel;
    Azman azman;


    public Oyuncu() {

        gargamel = new Gargamel();
        azman = new Azman();
        System.out.println("Gozluklu Sirin icin 1,Tembel Sirin icin 2'ye basiniz");
        Scanner myObj = new Scanner(System.in);
        name = myObj.nextInt();

        if (name == 1) {
            sprite = new Sprite(new Texture(Gdx.files.internal("gozluklu.png")));
            System.out.println("Karakterin : Gozlukluklu Sirin");
        }
        if (name == 2) {
            sprite = new Sprite(new Texture(Gdx.files.internal("tembel.png")));
            System.out.println("Karakterin : Tembel Sirin");
        }

        sprite.setSize(60, 60);
        sprite.setPosition(5 * 60, 5 * 60);
        sprite1.setSize(60, 60);
        sprite1.setPosition(12 * 60, 3 * 60);


        setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

        addListener(new InputListener() {

            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                if (puan > 0) {
                    if (keycode == Input.Keys.UP && Main.GAME_MAP[((int) (sprite.getY() + 60) / 60)][(int) sprite.getX() / 60] != 0) {
                        sprite.setPosition(sprite.getX(), sprite.getY() + 60);
                        if (name == 1 ) {
                            sprite.setPosition(sprite.getX(), sprite.getY() + 60);
                        }
                        gargamel.move();
                        gargamel.move();
                        azman.move();
                    }
                    if (keycode == Input.Keys.LEFT && Main.GAME_MAP[((int) (sprite.getY()) / 60)][(int) (sprite.getX() - 60) / 60] != 0) {
                        sprite.setPosition(sprite.getX() - 60, sprite.getY());
                        if (name == 1) {
                            sprite.setPosition(sprite.getX() - 60, sprite.getY());
                        }
                        gargamel.move();
                        gargamel.move();
                        azman.move();

                    }
                    if (keycode == Input.Keys.RIGHT && Main.GAME_MAP[((int) (sprite.getY()) / 60)][(int) (sprite.getX() + 60) / 60] != 0) {
                        sprite.setPosition(sprite.getX() + 60, sprite.getY());
                        if (name == 1 && (sprite.getX() + 60) / 60<13) {
                            sprite.setPosition(sprite.getX() + 60, sprite.getY());
                        }
                        gargamel.move();
                        gargamel.move();
                        azman.move();

                    }
                    if (keycode == Input.Keys.DOWN && Main.GAME_MAP[((int) (sprite.getY() - 60) / 60)][(int) sprite.getX() / 60] != 0) {
                        sprite.setPosition(sprite.getX(), sprite.getY() - 60);
                        if (name == 1) {
                            sprite.setPosition(sprite.getX(), sprite.getY() - 60);
                        }
                        gargamel.move();
                        gargamel.move();
                        azman.move();

                    }
                    //System.out.println("x: "+(sprite.getX()/60)+" y:"+sprite.getY()/60);
                    System.out.println("PUAN :" + puan);

                }

                return true;
            }
        });

    }

    public Oyuncu(String karakterAdi, String karakterID, String karakterTur) {

    }

    @Override
    public float getX() {
        return sprite.getX();
    }

    @Override
    public float getY() {
        return sprite.getY();
    }

    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(), getY());
        super.positionChanged();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {


        sprite.draw(batch);
        sprite1.draw(batch);


    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    public int puanGoster(){
        return puan;
    }

}
