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
import java.util.ArrayList;

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
    private int iniciar = 0;
    Server server;
    
    enum instruccion{INICIAR,MENSAJE,MENSAJEPRIVADO,CONSULTARENEMIGO,PASARINFO,INICIARPARTIDA,CREARPERSONAJE,SALTARTURNO,RENDIDO};
    
    public HiloServidor(Socket socketRef, Server server) throws IOException {
        this.socketRef = socketRef;
        reader = new DataInputStream(socketRef.getInputStream());
        writer = new DataOutputStream(socketRef.getOutputStream());
        this.server = server;
    }
    
    public void enviarTurnoInicial() throws IOException{
        writer.writeUTF("SETNAME");
        writer.writeUTF(server.getTurnoPrimero());
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
        String mensaje;
        String enemigo;
        switch (instruccion.valueOf(_instruccion.toUpperCase())){
            case INICIAR: // pasan el nombre del usuario
                nombre = reader.readUTF();
                enviarTurnoInicial();                    
                break;
                
            case MENSAJE: // pasan un mensaje por el chat
                mensaje = reader.readUTF();
                for (int i = 0; i < server.conexiones.size(); i++) {
                    HiloServidor current = server.conexiones.get(i);
                    current.writer.writeUTF("MENSAJE");
                    current.writer.writeUTF("Chat "+nombre);
                    current.writer.writeUTF(mensaje);
                }
                break;
            case MENSAJEPRIVADO:
                String privado = reader.readUTF();
                mensaje = reader.readUTF();
                boolean mandoMsj = false;
                for (int i = 0; i < server.conexiones.size(); i++) {
                    HiloServidor current = server.conexiones.get(i);
                    if(current.nombre.trim().toUpperCase().equals(privado.trim().toUpperCase())){
                        current.writer.writeUTF("MENSAJE");
                        current.writer.writeUTF("Chat privado "+nombre);
                        current.writer.writeUTF(mensaje);
                        writer.writeUTF("MENSAJE");
                        writer.writeUTF("Chat privado "+nombre);
                        writer.writeUTF(mensaje);
                        mandoMsj = true;
                        break;
                    }
                }
                if( !mandoMsj){
                    writer.writeUTF("MENSAJE");
                    writer.writeUTF("Chat privado "+"SERVER");
                    writer.writeUTF(" "+privado+" esta persona no se encuentra en el server vualva a tratar");
                }
                break;
                
            case CONSULTARENEMIGO:
                enemigo = reader.readUTF();
                for (int i = 0; i < server.conexiones.size(); i++) {
                    HiloServidor current = server.conexiones.get(i);
                    if(current.nombre.trim().toUpperCase().equals(enemigo.trim().toUpperCase())){
                        current.writer.writeUTF("CONSULTAINFO");
                        current.writer.writeUTF(nombre);
                        break;
                    }
                }
                break;
                
            case PASARINFO:
                enemigo = reader.readUTF();
                String info = reader.readUTF();
                for (int i = 0; i < server.conexiones.size(); i++) {
                    HiloServidor current = server.conexiones.get(i);
                    if(current.nombre.trim().toUpperCase().equals(enemigo.trim().toUpperCase())){
                        current.writer.writeUTF("PRINTEARINFO");
                        current.writer.writeUTF(info);
                        break;
                    }
                }
                break;
        
            case INICIARPARTIDA:
                iniciar ++;
                if(iniciar == server.conexiones.size()){
                    server.AcomodarTurnos();
                    for (int i = 0; i < server.conexiones.size(); i++) {
                    HiloServidor current = server.conexiones.get(i);
                        current.writer.writeUTF("RECIBIRTURNO");
                        current.writer.writeUTF(server.getTurno());
                        
                    }
                }
                break;
            case CREARPERSONAJE:
                    String nombre = reader.readUTF();
                    String url = reader.readUTF();
                    int Porcentaje = reader.readInt();
                    int Poder = reader.readInt();
                    int Resistencia = reader.readInt();
                    int Sanidad = reader.readInt();
                    for (int i = 0; i < server.conexiones.size(); i++) {
                     HiloServidor current3 = server.conexiones.get(i);
                        current3.writer.writeUTF("CREARPERSONAJE");
                        current3.writer.writeUTF(nombre);
                        current3.writer.writeUTF(url);
                        current3.writer.writeInt(Porcentaje);
                        current3.writer.writeInt(Poder);
                        current3.writer.writeInt(Resistencia);
                        current3.writer.writeInt(Sanidad);
                    }
                    

                break;
            
            case SALTARTURNO:
                for (int i = 0; i < server.conexiones.size(); i++) {
                     HiloServidor current5 = server.conexiones.get(i);
                       String nturno = server.getNextTurno();
                       current5.writer.writeUTF("RECIBIRTURNO");
                       current5.writer.writeUTF(nturno);
                    }
                break;
                
            case RENDIDO:
                String rendido = reader.readUTF();
                for (int i = 0; i < server.conexiones.size(); i++) {
                     HiloServidor current5 = server.conexiones.get(i);
                       current5.writer.writeUTF("RENDIRSE");
                       current5.writer.writeUTF(rendido);
                    }
                
                break;
            default:
                break;
        }
    }
    
    
}
