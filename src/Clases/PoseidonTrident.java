/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Cliente.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilberth
 */
public class PoseidonTrident extends Habilidades{
    Random random = new Random();

    public PoseidonTrident(Cliente refCliente,Luchador refPersonaje) {
        super("THREELINES", "THREENUMBRE", "CONTROLTHEKRAKEN",refCliente,refPersonaje,"POSEIDONTRIDENT");
    }

    @Override
    void attack1(String enemigo,ArrayList<Integer> posiciones) {
        // Se repite 3 veces pero sigo sin saber si son aleatoprios los lugares
            int x, y;
        for (int i = 0; i < posiciones.size(); i += 2) {
             int lado = random.nextInt(3);
             x = posiciones.get(i);
             y = posiciones.get(i+1);
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

    }

    @Override
    void attack2(String enemigo,ArrayList<Integer> posiciones) {
        //Pensar en la posibilidad ede mejor hacer una nueva clases para ataque
    }

    @Override
    void attack3(String enemigo,ArrayList<Integer> posiciones) {
        // Hablarlo con luis se ocupan mas cosas para hacer
    }
}
