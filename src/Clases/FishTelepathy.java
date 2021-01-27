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
public class FishTelepathy extends Habilidades{

    public FishTelepathy(Cliente refCliente,Luchador refPersonaje) {
        super("CARDUMEN", "SHARKATTACK", "PULP",refCliente,refPersonaje);
    }


    @Override
    void attack1(String enemigo) {
        int cant = random.nextInt(200)+100;
        int x, y;
        for(int i = 0; i< cant; i++){
            x = random.nextInt(20);
            y = random.nextInt(30);
            try {
                //casillas[x][y].danarCasilla(33);
                atacarEnemigo(x, y, refCliente.refPantalla.getTitle(),
                        enemigo, 33*refPersonaje.multDano,"CARDUMEN");
            } catch (IOException ex) {
                Logger.getLogger(FishTelepathy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    void attack2(String enemigo) {
        int esquinas = random.nextInt(4);
        for(int i = 0; i<= esquinas;i++){
            int esquina = random.nextInt(4);
            switch(esquina){
                case 0:
                    try {
                        //Esquina 0 superior izquierda
                        atTiburonIzArriba(enemigo,"SHARKATTACK");
                    } catch (IOException ex) {
                        Logger.getLogger(FishTelepathy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 1:
                    try {
                        //Esquina inferioir izquierda
                        atTiburonIzAbajo(enemigo,"SHARKATTACK");
                    } catch (IOException ex) {
                        Logger.getLogger(FishTelepathy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 2:
                    try {
                        //Esquina inferioir derecha
                        atTiburonDerAbajo(enemigo,"SHARKATTACK");
                    } catch (IOException ex) {
                        Logger.getLogger(FishTelepathy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;  
                case 3:
                    try {
                        //Esquina superior derecha
                        atTiburonDerArriba(enemigo,"SHARKATTACK");
                    } catch (IOException ex) {
                        Logger.getLogger(FishTelepathy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
        }
    }

    @Override
    void attack3(String enemigo) {
        Random random = new Random();
        int cant = random.nextInt(30)+20;
        int x, y;
        for(int i = 0; i < cant;i++){
            for (int j = 0; j < 8; j++) {
                x = random.nextInt(20);
                y = random.nextInt(30);
                //casillas[x][y].danarCasilla(25);
                try {
                    atacarEnemigo(x, y, refCliente.refPantalla.getTitle(),
                            enemigo, 25*refPersonaje.multDano,"PULP");
                } catch (IOException ex) {
                    Logger.getLogger(FishTelepathy.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private void atTiburonIzArriba(String enemigo, String tipoAtaque) throws IOException{
        int cant = random.nextInt(9)+1;
        int x = 0;
        int y = 0; //representan una esquina
        int x1 = x;
        int y1 = y;
        for(int i = 1; i <=cant*refPersonaje.multDano;i++){
            x1 += 1;
            y1 = y;
            if( x1 > 0|| x1 < 20 && y > 0 || y < 30)
                 //casillas[x1][y].danarCasilla(100);
                atacarEnemigo(x1, y, refCliente.refPantalla.getTitle(), enemigo, 100,tipoAtaque);
            for(int j = 1; j <= cant*refPersonaje.multDano;j++){
                y1 += 1;
                if( x1 > 0|| x1 < 20 && y1 > 0 || y1 < 30)
                    //casillas[x1][y1].danarCasilla(100);
                    atacarEnemigo(x1, y1, refCliente.refPantalla.getTitle(), enemigo, 100,tipoAtaque);
            }
        }
    }
    
    private void atTiburonIzAbajo(String enemigo,String tipoAtaque) throws IOException{
        int cant = random.nextInt(9)+1;
        int x = 0;
        int y = 30; //representan una esquina
        int x1 = x;
        int y1 = y;
        for(int i = 1; i <= cant*refPersonaje.multDano;i++){
            x1 += 1;
            y1 = y;
            if( x1 > 0|| x1 < 20 && y > 0 || y < 30)
                //casillas[x1][y].danarCasilla(100);
                atacarEnemigo(x1, y, refCliente.refPantalla.getTitle(), enemigo, 100, tipoAtaque);
            for(int j = 1; j <= cant*refPersonaje.multDano;j++){
                y1 -= 1;
                if( x1 > 0|| x1 < 20 && y1 > 0|| y1 < 30)
                    //casillas[x1][y1].danarCasilla(100);
                    atacarEnemigo(x1, y1, refCliente.refPantalla.getTitle(), enemigo, 100, tipoAtaque);
                    
            }
        }
    }
    
    private void atTiburonDerAbajo(String enemigo,String tipoAtaque) throws IOException{
        int cant = random.nextInt(9)+1;
        int x = 100;
        int y = 100; //representan una esquina
        int x1 = x;
        int y1 = y;
        for(int i = 1; i <=cant*refPersonaje.multDano;i++){
            x1 -= 10;
            y1 = y;
            if( x1 > 0|| x1 < 20 && y > 0 || y < 30)
                //casillas[x1][y].danarCasilla(100);
                atacarEnemigo(x1, y, refCliente.refPantalla.getTitle(), enemigo, 100, tipoAtaque);
            for(int j = 1; j <= cant*refPersonaje.multDano;j++){
                y1 -= 10;
                if( x1 > 0|| x1 < 20 && y1 > 0 || y1 < 30)
                    //casillas[x1][y1].danarCasilla(100);
                    atacarEnemigo(x1, y1, refCliente.refPantalla.getTitle(), enemigo, 100, tipoAtaque);
            }
        }
    }
    
    private void atTiburonDerArriba(String enemigo,String tipoAtaque) throws IOException{
        int cant = random.nextInt(9)+1;
        int x = 100;
        int y = 0; //representan una esquina
        int x1 = x;
        int y1 = y;
        for(int i = 1; i <=cant*refPersonaje.multDano;i++){
            x1 -= 10;
            y1 = y;
            if( x1 > 0|| x1 < 20 && y > 0 || y < 30)
                //casillas[x1][y].danarCasilla(100);
                atacarEnemigo(x1, y, refCliente.refPantalla.getTitle(), enemigo, 100, tipoAtaque);
            for(int j = 1; j <= cant*refPersonaje.multDano;j++){
                y1 += 10;
                if( x1 > 0|| x1 < 20 && y1 > 0 || y1 < 30)
                    //casillas[x1][y1].danarCasilla(100);
                    atacarEnemigo(x1, y1, refCliente.refPantalla.getTitle(), enemigo, 100, tipoAtaque);
            }
        }
    }
    
}
