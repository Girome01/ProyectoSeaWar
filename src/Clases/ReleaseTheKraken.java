/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Cliente.Cliente;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilberth
 */
public class ReleaseTheKraken extends Habilidades{
    Random random = new Random();

    public ReleaseTheKraken(Cliente refCliente) {
        super("TENTACULOS", "KRAKENBREATH", "RELEASETHEKRAKEN",refCliente);
    }

    @Override
    void attack1(String enemigo) {
        for(int i =0; i < 3; i++){
            int x = random.nextInt(20); // Saca la posicion x de la casilla del tablero
            int y = random.nextInt(30); // saca la posicion y de la casilla en el tablero
            try {
                ataqueArea(x, y, 1,enemigo,100,"TENTACULOS");
            } catch (IOException ex) {
                Logger.getLogger(ReleaseTheKraken.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    void attack2(String enemigo) {
       Random random = new Random();
       int lado = random.nextInt(3);
       int cantidad = random.nextInt(7)+1;
       int x = -1,y = -1;
       switch(lado){
           case 0: // arriba
               atArriba(enemigo,100,x,y,"KRAKENBREATH");
           case 1: // Abajo
               atAbajo(enemigo,100,x,y,"KRAKENBREATH");
               break;
           case 2: //Derecha
               atDerecha(enemigo,100,x,y,"KRAKENBREATH");
               break;
           case 3://Izquierda
               atIzquierda(enemigo,100,x,y,"KRAKENBREATH");
               break;
           default:
               System.out.println("Error en el alioento del kraken");
               break;
       }
    }

    @Override
    void attack3(String enemigo) {
        int x = -1, y = -1;
        int cant = random.nextInt(7)+1;
        try {
            ataqueArea(x, y, cant, enemigo,100,"RELEASETHEKRAKEN");
        } catch (IOException ex) {
            Logger.getLogger(ReleaseTheKraken.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
