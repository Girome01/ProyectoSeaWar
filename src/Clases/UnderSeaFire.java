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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Gilberth
 */
public class UnderSeaFire extends Habilidades{

    public UnderSeaFire(Cliente refCliente,Luchador refpersonaje) {
        super("VOLCANORAISING", "VOLCANOEXPLOSION", "TERMALRUSH",refCliente, refpersonaje,"UNDERSEAFIRE");
    }

    @Override
    void attack1(String enemigo,ArrayList<Integer> posiciones) {
        /*int x = random.nextInt(20), y = random.nextInt(30), cant = random.nextInt(9)+1;
        try {
            ataqueArea(x, y, cant, enemigo, 100);
        } catch (IOException ex) {
            Logger.getLogger(UnderSeaFire.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        Random random = new Random();
        System.out.println("LLego ataque 1");
        int x = random.nextInt(20), y = random.nextInt(30), cant = random.nextInt(9)+1;
        try {
            refCliente.hiloCliente.writer.writeUTF("RECIBIRDANOVOLCAN");
            refCliente.hiloCliente.writer.writeUTF(enemigo);
            refCliente.hiloCliente.writer.writeInt(x);
            refCliente.hiloCliente.writer.writeInt(y); 
            refCliente.hiloCliente.writer.writeDouble(100);
            refCliente.hiloCliente.writer.writeUTF(refCliente.refPantalla.getTitle());
            refCliente.hiloCliente.writer.writeInt(cant); 
        } catch (IOException ex) {
            Logger.getLogger(UnderSeaFire.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
        
        
    }

    @Override
    void attack2(String enemigo,ArrayList<Integer> posiciones) {
   
    }

    @Override
    void attack3(String enemigo,ArrayList<Integer> posiciones) {
       
    }
    
}
