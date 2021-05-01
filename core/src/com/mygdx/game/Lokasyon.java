

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;


public class Lokasyon extends Actor {

    private ShapeRenderer shapeRenderer;
    private int BIRIM_KARE = 30;
    private int a = 0;
    private int altınX[] = new int[6];
    private int altınY[] = new int[6];
    private Sprite altin1 = new Sprite(new Texture(Gdx.files.internal("altin.jpg")));
    private Sprite altin2 = new Sprite(new Texture(Gdx.files.internal("altin.jpg")));
    private Sprite altin3 = new Sprite(new Texture(Gdx.files.internal("altin.jpg")));
    private Sprite altin4 = new Sprite(new Texture(Gdx.files.internal("altin.jpg")));
    private Sprite altin5 = new Sprite(new Texture(Gdx.files.internal("altin.jpg")));
    private Sprite mantar = new Sprite(new Texture(Gdx.files.internal("mantar.png")));
    private boolean a1 = false;
    private boolean a2 = false;
    private boolean a3 = false;
    private boolean a4 = false;
    private boolean a5 = false;
    private boolean m = false;
    private float timeSeconds = 0f;
    private float period = 60f;
    private float x1,y1;
    private String name1,type1,name2,type2;


    Dijkstra dijkstra;

    public Lokasyon() {
        shapeRenderer = new ShapeRenderer();
        dijkstra = new Dijkstra();
        altin1.setSize(60, 60);
        altin2.setSize(60, 60);
        altin3.setSize(60, 60);
        altin4.setSize(60, 60);
        altin5.setSize(60, 60);
        mantar.setSize(60, 60);

        //spriteAltin.setPosition(300,300);
        setBounds(altin1.getX(), altin1.getY(), altin1.getWidth(), altin1.getHeight());
        setBounds(altin2.getX(), altin2.getY(), altin2.getWidth(), altin2.getHeight());
        setBounds(altin3.getX(), altin3.getY(), altin3.getWidth(), altin3.getHeight());
        setBounds(altin4.getX(), altin4.getY(), altin4.getWidth(), altin4.getHeight());
        setBounds(altin5.getX(), altin5.getY(), altin5.getWidth(), altin5.getHeight());
        setBounds(mantar.getX(), mantar.getY(), mantar.getWidth(), mantar.getHeight());

        Random random = new Random();


        while (a < 6) {
            int x = random.nextInt(11);
            int y = random.nextInt(13);


            if (Main.GAME_MAP[x][y] == 1) {
                altınX[a] = x;
                altınY[a] = y;
                a++;
                //System.out.println("x: "+y+" y:"+x);
            }

        }

    }

    public void setPoint(float x,float y){
        this.x1=x;
        this.y1=y;
    }

    public void setInfo(String name,String type){
        this.name1= name;
        this.type2=type;
    }




    @Override
    public void draw(Batch batch, float parentAlpha) {

        if (Main.oyuncu.sprite.getX() != 300 || Main.oyuncu.sprite.getY() != 300) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            for (int i = 2; i < Main.gargamel.dijkstra.path().length; i+=2 ) {

                shapeRenderer.setColor(Color.BLUE);
                shapeRenderer.rect( Main.gargamel.dijkstra.path()[i]* BIRIM_KARE*2,  Main.gargamel.dijkstra.path()[i+1] * BIRIM_KARE*2, BIRIM_KARE*2 , BIRIM_KARE*2 );

            }
            shapeRenderer.end();

            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            for (int i = 2; i < Main.azman.dijkstra.path().length; i+=2 ) {

                shapeRenderer.setColor(Color.PURPLE);
                shapeRenderer.rect( Main.azman.dijkstra.path()[i]* BIRIM_KARE*2+15,  Main.azman.dijkstra.path()[i+1] * BIRIM_KARE*2+15, BIRIM_KARE*2/2 , BIRIM_KARE*2/2 );

            }
            shapeRenderer.end();

        }

        //

        timeSeconds += Gdx.graphics.getRawDeltaTime();
        if (timeSeconds > period) {
            timeSeconds -= period;

        }


        super.draw(batch, parentAlpha);
        batch.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < Main.GAME_MAP[0].length; i++) {
            for (int j = 0; j < Main.GAME_MAP.length; j++) {
                if (Main.GAME_MAP[j][i] == 0) {
                    shapeRenderer.setColor(Color.BLACK);
                    shapeRenderer.rect(i * BIRIM_KARE * 2, j * BIRIM_KARE * 2, BIRIM_KARE * 2, BIRIM_KARE * 2);
                }


            }
        }
        shapeRenderer.end();


        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < Main.GAME_MAP[0].length; i++) {
            for (int j = 0; j < Main.GAME_MAP.length; j++) {
                if (Main.GAME_MAP[j][i] == 0) {
                    shapeRenderer.setColor(Color.BLACK);
                    shapeRenderer.rect(i * BIRIM_KARE * 2, j * BIRIM_KARE * 2, BIRIM_KARE * 2, BIRIM_KARE * 2);
                }


            }
        }
        shapeRenderer.end();


        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        for (int i = 0; i < Main.GAME_MAP[0].length; i++) {
            for (int j = 0; j < Main.GAME_MAP.length; j++) {
                shapeRenderer.setColor(Color.BLACK);
                shapeRenderer.rect(i * BIRIM_KARE * 2, j * BIRIM_KARE * 2, BIRIM_KARE * 2, BIRIM_KARE * 2);


            }
        }
        shapeRenderer.end();


        batch.begin();


        altin1.setPosition(altınY[0] * BIRIM_KARE * 2, altınX[0] * BIRIM_KARE * 2);
        altin2.setPosition(altınY[1] * BIRIM_KARE * 2, altınX[1] * BIRIM_KARE * 2);
        altin3.setPosition(altınY[2] * BIRIM_KARE * 2, altınX[2] * BIRIM_KARE * 2);
        altin4.setPosition(altınY[3] * BIRIM_KARE * 2, altınX[3] * BIRIM_KARE * 2);
        altin5.setPosition(altınY[4] * BIRIM_KARE * 2, altınX[4] * BIRIM_KARE * 2);
        mantar.setPosition(altınY[5] * BIRIM_KARE * 2, altınX[5] * BIRIM_KARE * 2);

        if (a1 == false && timeSeconds < 7) {
            altin1.draw(batch);
        }
        if (a2 == false && timeSeconds < 7) {
            altin2.draw(batch);
        }

        if (a3 == false && timeSeconds < 7) {
            altin3.draw(batch);
        }

        if (a4 == false && timeSeconds < 7) {
            altin4.draw(batch);
        }

        if (a5 == false && timeSeconds < 7) {
            altin5.draw(batch);
        }
        if (m == false && timeSeconds < 12) {
            mantar.draw(batch);
        }


        if (Main.oyuncu.sprite.getX() == altin1.getX() &&
                Main.oyuncu.sprite.getY() == altin1.getY() && a1 == false && timeSeconds < 7) {
            Main.oyuncu.puan += 5;
            a1 = true;
        }
        if (Main.oyuncu.sprite.getX() == altin2.getX() &&
                Main.oyuncu.sprite.getY() == altin2.getY() && a2 == false && timeSeconds < 7) {
            Main.oyuncu.puan += 5;
            a2 = true;
        }
        if (Main.oyuncu.sprite.getX() == altin3.getX() &&
                Main.oyuncu.sprite.getY() == altin3.getY() && a3 == false && timeSeconds < 7) {
            Main.oyuncu.puan += 5;
            a3 = true;
        }
        if (Main.oyuncu.sprite.getX() == altin4.getX() &&
                Main.oyuncu.sprite.getY() == altin4.getY() && a4 == false && timeSeconds < 7) {
            Main.oyuncu.puan += 5;
            a4 = true;
        }
        if (Main.oyuncu.sprite.getX() == altin5.getX() &&
                Main.oyuncu.sprite.getY() == altin5.getY() && a5 == false && timeSeconds < 7) {
            Main.oyuncu.puan += 5;
            a5 = true;
        }

        if (Main.oyuncu.sprite.getX() == mantar.getX() &&
                Main.oyuncu.sprite.getY() == mantar.getY() && m == false && timeSeconds < 12) {
            Main.oyuncu.puan += 50;
            m = true;
        }


    }



}
