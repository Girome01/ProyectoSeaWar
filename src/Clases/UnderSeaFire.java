/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Gilberth
 */
public class UnderSeaFire extends Habilidades{
    private ArrayList<Point> volcanes;
    private ArrayList<Integer> cant;

    public UnderSeaFire(Casillas[][] casillas) {
        super("VOLCANORAISING", "VOLCANOEXPLOSION", "TERMALRUSH",casillas);
    }

    @Override
    void attack1() {
        Random random = new Random();
        int x = random.nextInt(20), y = random.nextInt(30), cant = random.nextInt(9)+1;
        int x1 = x,x2 = x,y1,y2;
        for(int i = 1; i <=cant;i++){
            x1 += 1;
            x2 -= 1;
            y1 = y;
            y2 = y;
            if( x1 > 0|| x1 < 20 && y > 0 || y < 30)
                casillas[x1][y].danarCasilla(100);
            if( x2 > 0|| x2 < 20 && y > 0 || y < 30)
                casillas[x2][y].danarCasilla(100);
            for(int j = 1; j <= cant;j++){
                y1 -= 1;
                if( x > 0|| x < 20 && y1 > 0 || y1 < 30)
                    casillas[x][y1].danarCasilla(100);
                if( x1 > 0|| x1 < 20 && y1 > 0 || y1 < 30)
                    casillas[x1][y1].danarCasilla(100);
                if( x2 > 0|| x2 < 20 && y1 > 0 || y1 < 30)
                    casillas[x2][y1].danarCasilla(100);
                y2 += 1;
                if( x1 > 0|| x1 < 20 && y2 > 0 || y2 < 30)
                    casillas[x1][y2].danarCasilla(100);
                if( x1 > 0|| x1 < 20 && y2 > 0 || y2 < 30)
                    casillas[x][y2].danarCasilla(100);
                if( x2 > 0|| x2 < 20 && y2 > 0 || y2 < 30)
                    casillas[x2][y2].danarCasilla(100);
            }
        }
        volcanes.add(new Point(x,y));
        this.cant.add(cant);
    }

    @Override
    void attack3() {
        int x = 1,y = 1; // Luego ver como se reciben los numeros
        int x1 = x, x2 = x,y1, y2;
        //Hablar con luis para ver los tiempos que son 5 seg
        for(int k = 0; k < volcanes.size(); k++){
            if(volcanes.get(k).x == x && volcanes.get(k).y == y){
                int cant = this.cant.get(k);
                for(int i = 1; i <=cant;i++){
                x1 += 1;
                x2 -= 1;
                y1 = y;
                y2 = y;
                if( x1 > 0|| x1 < 20 && y > 0 || y < 30)
                    casillas[x1][y].danarCasilla(100);
                if( x2 > 0|| x2 < 20 && y > 0 || y < 30)
                    casillas[x2][y].danarCasilla(100);
                    for(int j = 1; j <= cant;j++){
                        y1 -= 1;
                        if( x > 0|| x < 20 && y1 > 0 || y1 < 30)
                            casillas[x][y1].danarCasilla(100);
                        if( x1 > 0|| x1 < 20 && y1 > 0 || y1 < 30)
                            casillas[x1][y1].danarCasilla(100);
                        if( x2 > 0|| x2 < 20 && y1 > 0 || y1 < 30)
                            casillas[x2][y1].danarCasilla(100);
                        y2 += 1;
                        if( x1 > 0|| x1 < 20 && y2 > 0 || y2 < 30)
                            casillas[x1][y2].danarCasilla(100);
                        if( x1 > 0|| x1 < 20 && y2 > 0 || y2 < 30)
                            casillas[x][y2].danarCasilla(100);
                        if( x2 > 0|| x2 < 20 && y2 > 0 || y2 < 30)
                            casillas[x2][y2].danarCasilla(100);
                    }
                }
            }
        }
    }

    @Override
    void attack2() {
        int xJ = 1,yJ = 1; // Luego ver como se reciben los numeros
        for(int i = 0; i < volcanes.size(); i++){
            if(volcanes.get(i).x == xJ && volcanes.get(i).y == yJ){
                Random random = new Random();
                int cant = random.nextInt(4)+1;
                for(int j = 0; j < cant;j++){
                    int x = random.nextInt(20), y = random.nextInt(30);
                    caerPiedra(i,x,y);
                }
            }
        }
    }
    
    private void caerPiedra(int pos, int x, int y){
        int cant = this.cant.get(pos)*10;
        int x1 = x, x2 = x, y1, y2;
        for(int i = 1; i <=cant;i++){
            x1 += 1;
            x2 -= 1;
            y1 = y;
            y2 = y;
            if( x1 > 0|| x1 < 20 && y > 0 || y < 30)
                casillas[x1][y].danarCasilla(100);
            if( x2 > 0|| x2 < 20 && y > 0 || y < 30)
                casillas[x2][y].danarCasilla(100);
            for(int j = 1; j <= cant;j++){
                y1 -= 1;
                if( x > 0|| x < 20 && y1 > 0 || y1 < 30)
                    casillas[x][y1].danarCasilla(100);
                if( x1 > 0|| x1 < 20 && y1 > 0 || y1 < 30)
                    casillas[x1][y1].danarCasilla(100);
                if( x2 > 0|| x2 < 20 && y1 > 0 || y1 < 30)
                    casillas[x2][y1].danarCasilla(100);
                y2 += 1;
                if( x1 > 0|| x1 < 20 && y2 > 0 || y2 < 30)
                    casillas[x1][y2].danarCasilla(100);
                if( x1 > 0|| x1 < 20 && y2 > 0 || y2 < 30)
                    casillas[x][y2].danarCasilla(100);
                if( x2 > 0|| x2 < 20 && y2 > 0 || y2 < 30)
                    casillas[x2][y2].danarCasilla(100);
            }
        }
    }
}
