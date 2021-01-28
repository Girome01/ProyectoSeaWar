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
public class ThunderUnderTheSea extends Habilidades{

    public ThunderUnderTheSea(Cliente refCliente,Luchador refPersonaje) {
        super("THUNDERRAIN", "POSEIDONTHUNDER", "EALATTACK",refCliente,refPersonaje,"THUNDERUNDERTHESEA");
    }

    @Override
    void attack1(String enemigo,ArrayList<Integer> posiciones) {
        int  x,y,dano;
        for(int i = 0; i < 100; i++){
            x = random.nextInt(20);
            y = random.nextInt(30);
            dano = random.nextInt(10)+10;
            if( x > 0|| x < 20 && y > 0 || y < 30)
                try {
                    //casillas[x][y].danarCasilla(dano);
                    atacarEnemigo(x, y, refCliente.refPantalla.getTitle(),
                            enemigo, dano*refPersonaje.multilpicador,"THUNDERRAIN");
                            
                } catch (IOException ex) {
                    Logger.getLogger(ThunderUnderTheSea.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }

    @Override
    void attack2(String enemigo,ArrayList<Integer> posiciones) {
        
        int x,y;
        int rayos = random.nextInt(5)+5;
        for (int i = 0; i < rayos; i++) {
            int cant = random.nextInt(9)+2;
            x = random.nextInt(20);
            y = random.nextInt(30);
            try {
                ataqueArea(x, y, cant, enemigo, 100, "POSEIDONTHUNDER");
            } catch (IOException ex) {
                Logger.getLogger(ThunderUnderTheSea.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
    }

    @Override
    void attack3(String enemigo,ArrayList<Integer> posiciones) {
        int x,y;
        int cant = random.nextInt(76)+25;
        int dano;
        for(int i = 0; i < cant;i++){
            x = random.nextInt(20);
            y = random.nextInt(30);
            dano = (random.nextInt(9)+1)*10;
            if( x > 0|| x < 20 && y > 0 || y < 30)
                try {
                    //casillas[x][y].danarCasilla(dano);
                    atacarEnemigo(x, y, refCliente.refPantalla.getTitle(), 
                            enemigo, dano*refPersonaje.multilpicador,"EALATTACK");
                    //danar la casilla esa cantidad
                } catch (IOException ex) {
                    Logger.getLogger(ThunderUnderTheSea.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
}
