/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Cliente.Cliente;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilberth
 */
public class UnderSeaFire extends Habilidades{

    public UnderSeaFire(Cliente refCliente,Luchador refpersonaje) {
        super("VOLCANORAISING", "VOLCANOEXPLOSION", "TERMALRUSH",refCliente, refpersonaje);
    }

    @Override
    void attack1(String enemigo) {
        /*int x = random.nextInt(20), y = random.nextInt(30), cant = random.nextInt(9)+1;
        try {
            ataqueArea(x, y, cant, enemigo, 100);
        } catch (IOException ex) {
            Logger.getLogger(UnderSeaFire.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    @Override
    void attack2(String enemigo) {
   
    }

    @Override
    void attack3(String enemigo) {
       
    }
    
}
