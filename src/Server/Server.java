/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Gilberth
 */
public class Server {
    PantallaServidor refPantalla;
    public ArrayList<HiloServidor> conexiones;
    private boolean running = true;
    private ServerSocket srv;
    private int turno = 0;
    private boolean partidaIniciada = false;
    
    public Server(PantallaServidor refPantalla) {
        this.refPantalla = refPantalla;
        conexiones = new ArrayList<HiloServidor>();
        this.refPantalla.setSrv(this);
    }

    public void iniciarPartida() {
        this.partidaIniciada = true;
    }
    
    public void stopserver(){
        running = false;
    }
    
    public String getNextTurno(){
        if ( ++turno >= conexiones.size())
            turno = 0;
        
        return conexiones.get(turno).nombre;
    }
    
    public String getTurno(){
        return conexiones.get(turno).nombre;
    }
    
    public void runServer(){
        int contadorDeConexiones = 0;
        try{
            srv = new ServerSocket(35577);
            while (running){
                refPantalla.addMessage("::Esperando conexión ...");
                Socket nuevaConexion = srv.accept();
                if (!partidaIniciada){ 
                    contadorDeConexiones++;
                    refPantalla.addMessage(":Conexión " + contadorDeConexiones + "aceptada");

                    // nuevo thread
                    HiloServidor newThread = new HiloServidor(nuevaConexion, this);
                    conexiones.add(newThread);
                    newThread.start();
                }
                else{
                    // OutputStream socket para poder hacer un writer
                    refPantalla.addMessage(":Conexión denegada: partida iniciada");
                }
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
}
