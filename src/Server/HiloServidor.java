/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

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
    
    public HiloServidor(Socket socketRef, Server server) throws IOException {
        this.socketRef = socketRef;
        reader = new DataInputStream(socketRef.getInputStream());
        writer = new DataOutputStream(socketRef.getOutputStream());
        this.server = server;
    }
    
    public void enviarTurnoInicial() throws IOException{
        writer.writeInt(1);
        writer.writeUTF(server.getTurno());
    }
    
    public void run (){
        
        int instruccionId = 1;
        while (running){
            try {
                instruccionId = reader.readInt(); // esperar hasta que reciba un entero
                
                switch (instruccionId){
                    case 1: // pasan el nombre del usuario
                        nombre = reader.readUTF();
                        enviarTurnoInicial();                    
                    break;
                    case 2: // pasan un mensaje por el chat
                        String mensaje = reader.readUTF();
                        
                        for (int i = 0; i < server.conexiones.size(); i++) {
                            HiloServidor current = server.conexiones.get(i);
                            current.writer.writeInt(2);
                            current.writer.writeUTF(nombre);
                            current.writer.writeUTF(mensaje);
                        }
                    break;
                }
            } catch (IOException ex) {
                
            }
        }
    }
    
    
    
}
