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
public class WavesControl extends Habilidades{
    private ArrayList<Point> remolinos;
    private ArrayList<Integer> cantArea;

    public WavesControl(Casillas[][] casillas) {
        super("SWIRLRAISING", "SENDHUMANGARBAGE", "RADIOCTIVERUSH",casillas);
    }

    @Override
    void attack1() {
        Random random = new Random();
        int x = -1, y = -1; //Como agregar las posiciones que escoje el usuario
        int cant = random.nextInt(8)+2;
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
        remolinos.add(new Point(x,y));
        cantArea.add(cant);
    }

    @Override
    void attack2() {
        Random random = new Random();
        int x = 1,y = 1; // Luego ver como se reciben los numeros
        //Hablar con luis para ver los tiempos que son 5 seg
        int rand;
        for(int j = 0; j < remolinos.size(); j++){
            if(remolinos.get(j).x == x && remolinos.get(j).y == y){
                int cant = this.cantArea.get(j)*10;
                int veces = random.nextInt(5)+1;
                for(int l = 0; l <= veces;l++ ){
                    int x1 = x, x2 = x,y1, y2;
                    for(int i = 1; i <= cant;i++){
                        x1 += 10;
                        x2 -= 10;
                        y1 = y;
                        y2 = y;
                        // danar los con 25%
                        rand = random.nextInt(2);
                        if( rand == 0){
                            if( x1 > 0|| x1 < 20 && y > 0 || y < 30){
                                casillas[x1][y].colocarBasuraRadio();
                                casillas[x1][y].danarCasilla(100); 
                            }
                        }else{
                            if( x1 > 0|| x1 < 20 && y > 0 || y < 30)
                                casillas[x1][y].danarCasilla(100);
                        }
                        rand = random.nextInt(2);
                        if( rand == 0){
                            if( x2 > 0|| x2 < 20 && y > 0 || y < 30){
                                casillas[x2][y].colocarBasuraRadio();
                                casillas[x2][y].danarCasilla(100);
                            }
                        }else{
                            if( x2 > 0|| x2 < 20 && y > 0 || y < 30)
                                casillas[x2][y].danarCasilla(100);
                        }
                        for(int k = 1; k <= cant;k++){
                            y1 -= 1;
                            rand = random.nextInt(2);
                            if( rand == 0){
                                if( x1 > 0|| x1 < 20 && y1 > 0 || y1 < 30){
                                    casillas[x1][y1].colocarBasuraRadio();
                                    casillas[x1][y1].danarCasilla(100);
                                }
                            }else{
                                if( x1 > 0|| x1 < 20 && y1 > 0 || y1 < 30)
                                    casillas[x1][y1].danarCasilla(100);
                            }
                            rand = random.nextInt(2);
                            if( rand == 0){
                                if( x > 0|| x < 20 && y1 > 0 || y1 < 30)
                                    casillas[x][y1].colocarBasuraRadio();
                                    casillas[x][y1].danarCasilla(100);
                            }else
                                if( x > 0|| x < 20 && y1 > 0 || y1 < 30)
                                    casillas[x][y1].danarCasilla(100);
                            rand = random.nextInt(2);
                            if( rand == 0){
                                if( x2 > 0|| x2 < 20 && y1 > 0 || y1 < 30)
                                    casillas[x2][y1].colocarBasuraRadio();
                                    casillas[x2][y1].danarCasilla(100);
                            }else
                                if( x2 > 0|| x2 < 20 && y1 > 0 || y1 < 30)
                                    casillas[x2][y1].danarCasilla(100);
                            y2 += 1;
                            rand = random.nextInt(2);
                            if( rand == 0){
                                if( x1 > 0|| x1 < 20 && y2 > 0 || y2 < 30){
                                    casillas[x1][y2].colocarBasuraRadio();
                                    casillas[x1][y2].danarCasilla(100);
                                }
                            }else{
                                if( x1 > 0|| x1 < 20 && y2 > 0 || y2 < 30)
                                    casillas[x1][y2].danarCasilla(100);
                            }
                            rand = random.nextInt(2);
                            if( rand == 0){
                                if( x > 0|| x < 20 && y1 > 0 || y1 < 30){
                                    casillas[x][y1].colocarBasuraRadio();
                                    casillas[x][y1].danarCasilla(100);
                                }
                            }else{
                                if( x > 0|| x < 20 && y1 > 0 || y1 < 30)
                                    casillas[x][y1].danarCasilla(100);
                            }
                            rand = random.nextInt(2);
                            if( rand == 0){
                                if( x > 0|| x < 20 && y2 > 0 || y2 < 30){
                                    casillas[x][y2].colocarBasuraRadio();
                                    casillas[x][y2].danarCasilla(100);
                                }
                            }else{
                                if( x > 0|| x < 20 && y2 > 0 || y2 < 30)
                                    casillas[x][y2].danarCasilla(100);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    void attack3() {
        //Ver el tiempo de dano
        for(int r = 0; r < 20; r++){
            for(int c = 0; c < 30;){
                if( casillas[r][c].isBasuraRadioactiva()){
                    if( r > 0|| r < 20 && c > 0 || c < 30)
                        casillas[r][c].danarCasilla(10);
                }
                c++;
            }                   
        }
    }
    
}
