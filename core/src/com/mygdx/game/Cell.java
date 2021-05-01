package com.mygdx.game;

public  class Cell {
    public int sat;
    public int sut;

    public Cell(int sat, int sut) {
        this.sat = sat;
        this.sut = sut;
    }
    @Override
    public String toString() {

        return sat + " " + sut;
    }

}
