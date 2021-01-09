/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Gilberth
 */
public class HiloCliente  extends Thread{
    private Socket socketRef;
    public DataInputStream reader;
    public DataOutputStream writer;
    public String nombre;
    private boolean running = true;
    private PantallaCliente refPantalla;
    
    enum instruccionCliente{SETNAME,MENSAJE};
    
    
    public HiloCliente(Socket socketRef, PantallaCliente refPantalla) throws IOException {
        this.socketRef = socketRef;
        reader = new DataInputStream(socketRef.getInputStream());
        writer = new DataOutputStream(socketRef.getOutputStream());
        this.refPantalla = refPantalla;
    }
    
    public void run (){
        
        String instruccionId = "";
        while (running){
            try {
                instruccionId = reader.readUTF(); // esperar hasta que reciba un entero
                instrucciones(instruccionId);
            } catch (IOException ex) {
                
            }
        }
    }
    
    private void instrucciones(String _instruccion) throws IOException{
        String usuario;
        switch (instruccionCliente.valueOf(_instruccion.toUpperCase())){
            case SETNAME: // recibe el turno del jufador 1
                refPantalla.setNombreTurno(reader.readUTF());
                break;
            case MENSAJE: // pasan un mensaje por el chat
                usuario = reader.readUTF();
                String mensaje = reader.readUTF();
                //System.out.println("CLIENTE Recibido mensaje: " + mensaje);
                refPantalla.addMensaje(usuario+">   " + mensaje);
                break;
            }
    }
    
}
