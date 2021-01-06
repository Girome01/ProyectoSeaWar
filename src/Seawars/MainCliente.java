/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seawars;

import Cliente.Cliente;
import Cliente.PantallaCliente;

/**
 *
 * @author Gilberth
 */
public class MainCliente {
    public static void main(String[] args) {
        try{
        PantallaCliente pantalla = new PantallaCliente();
        Cliente c = new Cliente(pantalla);
        pantalla.setVisible(true); 
        c.conectar(); 
        }
        catch(Exception e){
            
        }
    }
}
