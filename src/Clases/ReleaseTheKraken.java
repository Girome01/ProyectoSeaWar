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

    public ReleaseTheKraken() {
        super("TENTACULOS", "KRAKENBREATH", "RELEASETHEKRAKEN");
    }

    @Override
    void attack1() {
        Random random = new Random();
        for(int i =0; i< 3; i++){
            int x = random.nextInt(100); // Saca la posicion x de la casilla del tablero
            int y = random.nextInt(100); // saca la posicion y de la casilla en el tablero
            /*
            OCUPAMOS VER COMO SE DESTRUYEN LAS CASILLAS Y COMO SE LES HACE DANO
            destruir ( x+10, y+10 )
            destruir ( x, y+10 )
            destruir ( x-10, y+10 )
            destruir ( x-10, y )
            destruir ( x-10, y-10)
            destruir ( x, y-10)
            destruir ( x+10, y-10)
            destruir ( x+10,y)
            */
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
                   /*
                   y -= 10
                   destruir (x,y) 
                   */
               }
               break;
           case 1: // Abajo
               for(int i = 0; i < cantidad; i++){
                   /*
                   y += 10
                   destruir (x,y) 
                   */
               }
               break;
           case 2: //Derecha
               for(int i = 0; i < cantidad; i++){
                   /*
                   x += 10
                   destruir (x,y) 
                   */
               }
               break;
           case 3://Izquierda
               for(int i = 0; i < cantidad; i++){
                   /*
                   x -= 10
                   destruir (x,y) 
                   */
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
            x1 += 10;
            x2 -= 10;
            y1 = y;
            y2 = y;
            //destruir (x1,y)
            //destruir (x2,y)
            for(int j = 1; j <= cant;j++){
                y1 -= 10;
                //destruir (x1,y1)
                y2 += 10;
                //destruir (x1,y2)
                //destruir (x,y1)
                //destruir (x,y2)
            }
        }
    }
    
}
