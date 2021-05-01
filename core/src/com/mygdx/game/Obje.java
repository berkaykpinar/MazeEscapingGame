package com.mygdx.game;

public class Obje {
    private String isim;
    private int puan;
    private int konumX;
    private int konumY;
    private int zaman;

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public int getKonumX() {
        return konumX;
    }

    public void setKonumX(int konumX) {
        this.konumX = konumX;
    }

    public int getKonumY() {
        return konumY;
    }

    public void setKonumY(int konumY) {
        this.konumY = konumY;
    }

    public void setZaman(int zaman) {
        this.zaman = zaman;
    }

    public int getZaman() {
        return zaman;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
}
