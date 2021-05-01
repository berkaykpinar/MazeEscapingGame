package com.mygdx.game;

import java.util.*;

public class Dijkstra {

    private int cord[];
    private static Stack<Integer> kordinat = new Stack<>();
    private  static HashMap<Integer,Integer> kor = new HashMap<Integer,Integer>();
    private static int sorX;
    private static int sorY;
    private static int desX;
    private static int desY;
    public static int map[][];

    public Dijkstra(){

    }


    public Dijkstra(int map[][],int sorX,int sorY , int desX,int desY){
        this.map=map;
        this.sorX=sorX;
        this.sorY=sorY;
        this.desX=desX;
        this.desY=desY;

        Stack<Cell> path = new Stack<>();
        enKisaYol(map, new Cell(sorX, sorY), new Cell(desX, desY), path);

        String temp;
        String t[];
        int[] tmp = new int[2];
        int x,y;

        while (!path.isEmpty()) {
            temp=path.pop()+" ";
            t=temp.split(" ");
            x=Integer.parseInt(t[0]);
            y=Integer.parseInt(t[1]);
           // System.out.println("X : "+x+" Y: "+y);
            kordinat.push(x);
            kordinat.push(y);

        }

        cord=new int[kordinat.size()];

        int i =0;
        while (!kordinat.isEmpty()){
            cord[i]=kordinat.pop();
            i++;
        }



    }

    public int[] path(){
        return this.cord;
    }



    public static int enKisaYol(int[][] map, Cell start, Cell end,
                                Stack<Cell> path) {


        // mesafeler sonsuzla doldurulur - Kolay olması bakımından 100 ile
        int[][] distances = new int[map.length][];

        for (int i = 0; i < map.length; i++) {
            distances[i] = new int[map[i].length];
            Arrays.fill(distances[i], 100);
        }


        // start node 0 almalıdır
        int distance = 0;
        List<Cell> currentCells = Arrays.asList(start);


        while (distances[end.sat][end.sut] == 100
                && !currentCells.isEmpty()) {

            List<Cell> nextCells = new ArrayList<>();

            for (Cell cell : currentCells) {

                if (distances[cell.sat][cell.sut] == 100
                        && !(map[cell.sat][cell.sut] == 0)) {

                    distances[cell.sat][cell.sut] = distance;
                    //System.out.print(distances[cell.row][cell.col]+" ");
                    komsuEkle(cell, nextCells, map.length, map[0].length);
                }

            }


            // prepare for next round
            currentCells = nextCells;
            distance++;
        }

        for(int h =0;h<11;h++){
            for(int g=0;g<13;g++){
                System.out.print(distances[h][g]+"    ");
            }
           System.out.println();
        }



        // yolu bulur
        if (distances[end.sat][end.sut] < 100) {
            Cell cell = end;
            path.push(end);
            for (int d = distances[end.sat][end.sut]-1; d >= 0; d--) {
                cell = komsuAl(cell, d, distances);
                path.push(cell);
            }
        }

        return distances[end.sat][end.sut];
    }

    // Oyun sahasının dışına çıkmayı engeller
    private static boolean mevcutMu(int row, int col, int maxRow, int maxCol) {
        return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
    }

   //labirentte sağ sol aşağı yukarı komşuları gezer
    private static void komsuEkle(Cell cell, List<Cell> list,
                                  int maxRow, int maxCol) {
        int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : ds) {
            int row = cell.sat + d[0];
            int col = cell.sut + d[1];
            if (mevcutMu(row, col, maxRow, maxCol))
                list.add(new Cell(row, col));
        }
    }

    // belirli bir kare ile başlangıç noktası arasındaki uzaklığı alır
    private static Cell komsuAl(Cell cell, int distance, int[][] distances) {
        int[][] ds = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] d : ds) {
            int row = cell.sat + d[0];
            int col = cell.sut + d[1];
            if (mevcutMu(row, col, distances.length, distances[0].length)
                    && distances[row][col] == distance)
                return new Cell(row, col);
        }
        return null;
    }



    public static void main(String[] args) {

    }

}
