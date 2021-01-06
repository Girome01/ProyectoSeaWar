/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seawars;

import Server.PantallaServidor;
import Server.Server;

/**
 *
 * @author Gilberth
 */
public class MainServer {
     public static void main(String[] args) {
        PantallaServidor pantalla = new PantallaServidor();
        Server srv = new Server(pantalla);
        pantalla.setVisible(true);
        srv.runServer();
        
    }
}
