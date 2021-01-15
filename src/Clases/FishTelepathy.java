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
public class FishTelepathy extends Habilidades{

    public FishTelepathy(Casillas[][] casillas) {
        super("CARDUMEN", "SHARKATTACK", "PULP",casillas);
    }


    @Override
    void attack1() {
        Random random = new Random();
        int cant = random.nextInt(200)+100;
        int x, y;
        for(int i = 0; i< cant; i++){
            x = random.nextInt(20);
            y = random.nextInt(30);
            casillas[x][y].danarCasilla(33);
        }
    }

    @Override
    void attack2() {
        Random random = new Random();
        int esquinas = random.nextInt(3);
        for(int i = 0; i<= esquinas;i++){
            int esquina = random.nextInt(3);
            int cant = random.nextInt(9)+1;
            int x = 0,y = 0; //representan una esquina
            int x1 = x, y1 = y;
            switch(esquina){
                case 0://Esquina 0 superior izquierda
                    cant = random.nextInt(9)+1;
                    x = 0;
                    y = 0; //representan una esquina
                    x1 = x;
                    y1 = y;
                    for(int j = 1; j <=cant;i++){
                        x1 += 1;
                        y1 = y;
                        if( x1 > 0|| x1 < 20 && y > 0 || y < 30)
                            casillas[x1][y].danarCasilla(100);
                        for(int k = 1; k <= cant;j++){
                            y1 += 1;
                            if( x1 > 0|| x1 < 20 && y1 > 0 || y1 < 30)
                                casillas[x1][y1].danarCasilla(100);
                            
                        }
                    }
                    break;
                case 1://Esquina inferioir izquierda
                    cant = random.nextInt(9)+1;
                    x = 0;
                    y = 30; //representan una esquina
                    x1 = x;
                    y1 = y;
                    for(int j = 1; j <=cant;i++){
                        x1 += 1;
                        y1 = y;
                        if( x1 > 0|| x1 < 20 && y > 0 || y < 30)
                            casillas[x1][y].danarCasilla(100);
                        for(int k = 1; k <= cant;j++){
                            y1 -= 1;
                            if( x1 > 0|| x1 < 20 && y1 > 0|| y1 < 30)
                                casillas[x1][y1].danarCasilla(100);
                        }
                    }
                    break;
                case 2://Esquina inferioir derecha
                    cant = random.nextInt(9)+1;
                    x = 100;
                    y = 100; //representan una esquina
                    x1 = x;
                    y1 = y;
                    for(int j = 1; j <=cant;i++){
                        x1 -= 10;
                        y1 = y;
                        if( x1 > 0|| x1 < 20 && y > 0 || y < 30)
                            casillas[x1][y].danarCasilla(100);
                        for(int k = 1; k <= cant;j++){
                            y1 -= 10;
                            if( x1 > 0|| x1 < 20 && y1 > 0 || y1 < 30)
                                casillas[x1][y1].danarCasilla(100);
                        }
                    }
                    break; 
                case 3://Esquina superior derecha
                    cant = random.nextInt(9)+1;
                    x = 100;
                    y = 0; //representan una esquina
                    x1 = x;
                    y1 = y;
                    for(int j = 1; j <=cant;i++){
                        x1 -= 10;
                        y1 = y;
                        if( x1 > 0|| x1 < 20 && y > 0 || y < 30)
                            casillas[x1][y].danarCasilla(100);
                        for(int k = 1; k <= cant;j++){
                            y1 += 10;
                            if( x1 > 0|| x1 < 20 && y1 > 0 || y1 < 30)
                                casillas[x1][y1].danarCasilla(100);
                        }
                    }
                    break;
            }
        }
    }

    @Override
    void attack3() {
        Random random = new Random();
        int cant = random.nextInt(30)+20;
        int x, y;
        for(int i = 0; i < cant;i++){
            for (int j = 0; j < 8; j++) {
                x = random.nextInt(20);
                y = random.nextInt(30);
                casillas[x][y].danarCasilla(25);
            }
        }
    }
    
}
