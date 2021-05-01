//Bu proje Berkay AKPINAR (180201112) ve Esra Gerekmen (160201021) tarafından yapılmıştır.


package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends ApplicationAdapter {
    public static Oyuncu oyuncu;
    public static Gargamel gargamel;
    public static Azman azman;
    private Stage stage;
    private OrthographicCamera camera;
    private Viewport viewport;
    private TextField textField1;
    private TextField textField2;
    private Skin MySkin;
    public static int[][] GAME_MAP;
    private ShapeRenderer shapeRenderer;
    private int[] startingPoint;
    private String s;
    private char p1;
    private char p2;

    @Override
    public void create() {

        stage = new Stage(new ScreenViewport());

        GAME_MAP = new int[11][13];
        MySkin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        Gdx.input.setInputProcessor(stage);

        try {
            Scanner map = new Scanner(new File("harita.txt"));
            s=map.next();
            p1=s.charAt(s.length()-1);
            s=map.next();
            p2=s.charAt(s.length()-1);

            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 13; j++) {
                    GAME_MAP[10 - i][j] = map.nextInt();
                }
                map.hasNextLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //GozlukluSirin gozlukluSirin = new GozlukluSirin();
        //TembelSirin tembelSirin = new TembelSirin();

        Altin altin = new Altin();
        Mantar mantar = new Mantar();
        System.out.println(mantar.getIsim());


        gargamel = new Gargamel();
        oyuncu = new Oyuncu();
        azman = new Azman();
        gargamel.setStartCoord(startingPoint = getDoor(p2));
        azman.setStartCoord(startingPoint = getDoor(p1));
        Lokasyon lokasyon = new Lokasyon();
        stage.addActor(lokasyon);
        stage.addActor(gargamel);
        stage.addActor(oyuncu);
        stage.addActor(azman);

//        lokasyon.setPoint(gozlukluSirin.getX(),gozlukluSirin.getY());
//        lokasyon.setInfo(gozlukluSirin.getName(),gozlukluSirin.getType());
//
//        lokasyon.setPoint(tembelSirin.getX(),tembelSirin.getY());
//        lokasyon.setInfo(tembelSirin.getName(),tembelSirin.getType());

        Gdx.input.setInputProcessor(stage);
        shapeRenderer = new ShapeRenderer();
        stage.setKeyboardFocus(oyuncu);

    }


    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Label label = new Label("Sirineyi Kurtar", MySkin);
        label.setPosition(Gdx.graphics.getWidth() - 900, Gdx.graphics.getHeight() - 40);
        label.setSize(100, 30);
        label.setFontScale(3);
        label.setColor(Color.BLUE);
        stage.addActor(label);

        textField1 = new TextField("Puan :  " + String.valueOf(oyuncu.puan), MySkin);
        textField1.setPosition(Gdx.graphics.getWidth() - 400, Gdx.graphics.getHeight() - 400);
        textField1.setSize(200, 20);
        textField1.setColor(Color.BLACK);
        stage.addActor(textField1);

        if (oyuncu.puan <= 0) {
            textField2 = new TextField("Puanin bitti. Sirineyi kurtaramadin !  ", MySkin);
            textField2.setPosition(Gdx.graphics.getWidth() - 400, Gdx.graphics.getHeight() - 500);
            textField2.setSize(300, 20);
            textField2.setColor(Color.RED);
            stage.addActor(textField2);
        }
        if (oyuncu.sprite.getX() == oyuncu.sprite1.getX() &&
                oyuncu.sprite.getY() == oyuncu.sprite1.getY()) {
            textField2 = new TextField("Tebrikler . Sirineyi kurtardin !  ", MySkin);
            textField2.setPosition(Gdx.graphics.getWidth() - 400, Gdx.graphics.getHeight() - 500);
            textField2.setSize(300, 20);
            textField2.setColor(Color.BLUE);
            stage.addActor(textField2);

        }



        stage.draw();
        stage.act(Gdx.graphics.getDeltaTime());


    }

    @Override
    public void dispose() {

    }

    public int[] getDoor(char h){
        if(h =='A'){
            int x[] = {3,10} ;
            return x;
        }
        else if(h =='B'){
            int x[] = {10,10} ;
            return x;
        }
        else if(h =='C'){
            int x[] = {0,5} ;
            return x;
        }
        else {
            int x[] = {3,0} ;
            return x;
        }
        //b=(10,10)
        //c=(0,5)
        //d=(3,0)
    }


}
