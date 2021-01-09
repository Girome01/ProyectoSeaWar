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

    public ThunderUnderTheSea() {
        super("THUNDERRAIN", "POSEIDONTHUNDER", "EALATTACK");
    }

    @Override
    void attack1() {
        Random random = new Random();
        int x, y, dano;
        for(int i = 0; i < 100; i++){
            x = random.nextInt(100);
            y = random.nextInt(100);
            dano = random.nextInt(10)+10;
            // danar la cantidad de danoi en %
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

    @Override
    void attack3() {
        Random random = new Random();
        int cant = random.nextInt(75)+25;
        int x,y,dano;
        for(int i = 0; i < cant;i++){
            x = random.nextInt(100);
            y = random.nextInt(100);
            dano = (random.nextInt(9)+1)*10;
            //danar la casilla esa cantidad
        }
    }
    
}
