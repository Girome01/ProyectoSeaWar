/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Random;

/**
 *
 * @author Gilberth
 */
public class ReleaseTheKraken extends Habilidades{

    public ReleaseTheKraken(Casillas[][] casillas) {
        super("TENTACULOS", "KRAKENBREATH", "RELEASETHEKRAKEN",casillas);
    }

    @Override
    void attack1() {
        Random random = new Random();
        for(int i =0; i < 3; i++){
            int x = random.nextInt(100); // Saca la posicion x de la casilla del tablero
            int y = random.nextInt(100); // saca la posicion y de la casilla en el tablero
            casillas[x+1][y+1].danarCasilla(100);
            casillas[x][y+1].danarCasilla(100);
            casillas[x-1][y+1].danarCasilla(100);
            casillas[x-1][y].danarCasilla(100);
            casillas[x-1][y-1].danarCasilla(100);
            casillas[x][y-1].danarCasilla(100);
            casillas[x+1][y-1].danarCasilla(100);
            casillas[x+1][y].danarCasilla(100);
            casillas[x][y].danarCasilla(100);
        }
    }

    @Override
    void attack2() {
       Random random = new Random();
       int lado = random.nextInt(3);
       int cantidad = random.nextInt(7)+1;
       int x = -1,y = -1;
       switch(lado){
           case 0: // arriba
               for(int i = 0; i < cantidad; i++){
                   y -= 1;
                   casillas[x][y].danarCasilla(100);
               }
               break;
           case 1: // Abajo
               for(int i = 0; i < cantidad; i++){
                   y += 1;
                   casillas[x][y].danarCasilla(100);
               }
               break;
           case 2: //Derecha
               for(int i = 0; i < cantidad; i++){
                   x += 10;
                   casillas[x][y].danarCasilla(100);
               }
               break;
           case 3://Izquierda
               for(int i = 0; i < cantidad; i++){
                   x -= 10;
                   casillas[x][y].danarCasilla(100);
               }
               break;
           default:
               System.out.println("Error en el alioento del kraken");
               break;
       }
    }

    @Override
    void attack3() {
        Random random = new Random();
        int x = -1, y = -1;
        int x1 = x,x2 = x,y1,y2;
        int cant = random.nextInt(7)+1;
        for(int i = 1; i <=cant;i++){
            x1 += 1;
            x2 -= 1;
            y1 = y;
            y2 = y;
            casillas[x1][y].danarCasilla(100);
            casillas[x2][y].danarCasilla(100);
            for(int j = 1; j <= cant;j++){
                y1 -= 1;
                casillas[x][y1].danarCasilla(100);
                y2 += 1;
                casillas[x1][y2].danarCasilla(100);
                casillas[x][y1].danarCasilla(100);
                casillas[x][y2].danarCasilla(100);
            }
        }
    }
    
}
