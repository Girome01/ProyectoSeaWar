/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Clases.CommandManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Gilberth
 */
public class HiloServidor extends Thread{
    private Socket socketRef;
    private DataInputStream reader;
    private DataOutputStream writer;
    public String nombre;
    private boolean running = true;
    Server server;
    
    enum instruccion{INICIAR,COMMAND,MENSAJE};
    
    public HiloServidor(Socket socketRef, Server server) throws IOException {
        this.socketRef = socketRef;
        reader = new DataInputStream(socketRef.getInputStream());
        writer = new DataOutputStream(socketRef.getOutputStream());
        this.server = server;
    }
    
    public void enviarTurnoInicial() throws IOException{
        writer.writeUTF("SETNAME");
        writer.writeUTF(server.getTurno());
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
        
        switch (instruccion.valueOf(_instruccion.toUpperCase())){
            case INICIAR: // pasan el nombre del usuario
                nombre = reader.readUTF();
                enviarTurnoInicial();                    
                break;
                
            case MENSAJE: // pasan un mensaje por el chat
                String mensaje = reader.readUTF();
                for (int i = 0; i < server.conexiones.size(); i++) {
                    HiloServidor current = server.conexiones.get(i);
                    current.writer.writeUTF("MENSAJE");
                    current.writer.writeUTF(nombre);
                    current.writer.writeUTF(mensaje);
                }
                break;
                
            default:
                break;
        }
    }
    
    
}
