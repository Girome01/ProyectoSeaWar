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
public class ThunderUnderTheSea extends Habilidades{

    public ThunderUnderTheSea(Casillas[][] casillas) {
        super("THUNDERRAIN", "POSEIDONTHUNDER", "EALATTACK",casillas);
    }

    @Override
    void attack1() {
        Random random = new Random();
        int x, y, dano;
        for(int i = 0; i < 100; i++){
            x = random.nextInt(20);
            y = random.nextInt(30);
            dano = random.nextInt(10)+10;
            casillas[x][y].danarCasilla(dano);
        }
    }

    @Override
    void attack2() {
        Random random = new Random();
        int x = -1, y = -1;
        int x1 = x,x2 = x,y1,y2;
        int rayos = random.nextInt(5)+5;
        int cant = random.nextInt(8)+2;
        for(int k = 0; k < rayos; k ++){
            for(int i = 1; i <=cant;i++){
                x1 += 1;
                x2 -= 1;
                y1 = y;
                y2 = y;
                casillas[x1][y].danarCasilla(100);
            casillas[x2][y].danarCasilla(100);
                for(int j = 1; j <= cant;j++){
                    y1 -= 1;
                    casillas[x1][y1].danarCasilla(100);
                    y2 += 1;
                    casillas[x1][y2].danarCasilla(100);
                    casillas[x][y1].danarCasilla(100);
                    casillas[x][y2].danarCasilla(100);
                }
            }
        }
    }

    @Override
    void attack3() {
        Random random = new Random();
        int cant = random.nextInt(75)+25;
        int x,y,dano;
        for(int i = 0; i < cant;i++){
            x = random.nextInt(20);
            y = random.nextInt(30);
            dano = (random.nextInt(9)+1)*10;
            casillas[x][y].danarCasilla(dano);
            //danar la casilla esa cantidad
        }
    }
    
}
