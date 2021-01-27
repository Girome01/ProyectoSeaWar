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
public class PoseidonTrident extends Habilidades{
    Random random = new Random();

    public PoseidonTrident(Cliente refCliente) {
        super("THREELINES", "THREENUMBRE", "CONTROLTHEKRAKEN",refCliente);
    }

    @Override
    void attack1(String enemigo) {
        // Se repite 3 veces pero sigo sin saber si son aleatoprios los lugares
        int lado = random.nextInt(3);
        int x = -1,y = -1;
        switch(lado){
            case 0: // arriba
                atArriba(enemigo,100,x,y,"THREELINES");
                break;
            case 1: // Abajo
                atAbajo(enemigo,100,x,y,"THREELINES");
                break;
            case 2: //Derecha
                atDerecha(enemigo,100,x,y,"THREELINES");
                break;
            case 3://Izquierda
                atIzquierda(enemigo,100,x,y,"THREELINES");
                break;
            default:
                System.out.println("Error en el alioento del kraken");
                break;
        }
    }

    @Override
    void attack2(String enemigo) {
        //Pensar en la posibilidad ede mejor hacer una nueva clases para ataque
    }

    @Override
    void attack3(String enemigo) {
        // Hablarlo con luis se ocupan mas cosas para hacer
    }
}
