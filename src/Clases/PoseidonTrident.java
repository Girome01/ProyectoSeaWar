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
public class PoseidonTrident extends Habilidades{

    public PoseidonTrident(Casillas[][] casillas) {
        super("THREELINES", "THREENUMBRE", "CONTROLTHEKRAKEN",casillas);
    }

    @Override
    void attack1() {
        // Se repite 3 veces pero sigo sin saber si son aleatoprios los lugares
        Random random = new Random();
        int lado = random.nextInt(3);
        int cantidad = random.nextInt(3)+1;
        int x = -1,y = -1;
        switch(lado){
            case 0: // arriba
                for(int i = 0; i < cantidad; i++){
                    y -= 1;
                    if( x > 0|| x < 20 && y > 0 || y < 30)
                        casillas[x][y].danarCasilla(100);
                }
                break;
            case 1: // Abajo
                for(int i = 0; i < cantidad; i++){
                    y += 1;
                    if( x > 0|| x < 20 && y > 0 || y < 30)
                        casillas[x][y].danarCasilla(100);
                }
                break;
            case 2: //Derecha
                for(int i = 0; i < cantidad; i++){
                    x += 1;
                    if( x > 0|| x < 20 && y > 0 || y < 30)
                        casillas[x][y].danarCasilla(100);
                }
                break;
            case 3://Izquierda
                for(int i = 0; i < cantidad; i++){
                    x -= 1;
                    if( x > 0|| x < 20 && y > 0 || y < 30)
                        casillas[x][y].danarCasilla(100);
                }
                break;
            default:
                System.out.println("Error en el alioento del kraken");
                break;
        }
    }

    @Override
    void attack2() {
        //Pensar en la posibilidad ede mejor hacer una nueva clases para ataque
    }

    @Override
    void attack3() {
        // Hablarlo con luis se ocupan mas cosas para hacer
    }
    
}
