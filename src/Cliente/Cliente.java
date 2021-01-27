/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Clases.Luchador;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gilberth
 */
public class Cliente {
    Socket socketRef;
    public ArrayList<Integer> Poder= new ArrayList<Integer>();
    public ArrayList<Integer> Sanidad = new ArrayList<Integer>();
    public ArrayList<Integer> Resistencia = new ArrayList<Integer>();
    public ArrayList<String> AtaquesRecibido = new ArrayList<String>();
    public ArrayList<String> AtaquesExitosos = new ArrayList<String>();
    public ArrayList<String> AtaquesNoExitosos = new ArrayList<String>();
    public PantallaCliente refPantalla;
    public HiloCliente hiloCliente;
    public String turno;
    public ArrayList<Luchador> personajes;
    public boolean rendido = false;
    public int multDano = 1;
    private int cantidadPersonajes = 1;
    public int PorPoblacion = 0;

    
    public Cliente(PantallaCliente refPantalla) {
        this.refPantalla = refPantalla;
        refPantalla.setRefCliente(this);
        personajes = new ArrayList<Luchador>();
    }
    
    public void conectar(){
 
        try{
        
            socketRef = new Socket("localhost", 35577);
            hiloCliente = new HiloCliente(socketRef, refPantalla);
            hiloCliente.start();
            String nombre = JOptionPane.showInputDialog("Introduzca un Nick:");
            refPantalla.setTitle(nombre);
            hiloCliente.writer.writeUTF("INICIAR"); //instruccion para el switch del thraed servidor
            hiloCliente.writer.writeUTF(nombre); //instruccion para el switch del thraed servidor
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    
    }
    
    private String obtenerPor(){
        int vivas = 0;
        for(int r=0; r<20; r++){
            for(int c=0; c<30;){
                if(refPantalla.casillas[r][c].estaViva()){
                    vivas+=1;
                }
            }
        }
        return ( vivas*100/600 )+" ";
    }
    
    
    
    public void CrearPersonaje(String _Nombre, String Url, int _PorcentajePoblacion, int _Poder, int _Resistencia, int _Sanidad,String Ataque){
        Luchador tmp = new Luchador( _Nombre,  Url,  _PorcentajePoblacion, _Poder,  _Resistencia,  _Sanidad, Ataque,this);
        personajes.add(tmp);
        refPantalla.SetInfoPersonaje(Url, _Sanidad, _Poder, _Resistencia,cantidadPersonajes);
        cantidadPersonajes = cantidadPersonajes +1;
    }
    
    private String casillasMuertas(){
        int muertas = 0;
        for(int r=0; r<20; r++){
            for(int c=0; c<30;){
                if( !refPantalla.casillas[r][c].estaViva()){
                    muertas += 1;
                }
            }
        }
        return muertas+"";
    }
    
    public String obtenerInfo(){
        return refPantalla.getTitle()+" Porcentaje de casillas vivas: "+obtenerPor()+
                "Casillas muertas totales: "+casillasMuertas();
    }
    
    public void recibirdano(int x, int y, double dano, String enemigoE,String ataque) throws IOException{
        if(refPantalla.casillas[x][y].estaViva()){
            refPantalla.casillas[x][y].danarCasilla(dano); //Multiplicarlo por resistencia
            refPantalla.casillas[x][y].recibirDatAtaque("El enemigo"+enemigoE+" ataco con "+
                    ataque+" causando "+ dano+" de dano."); // multiplicarlo por resistencia
            System.out.println("Jugador: " + refPantalla.getTitle()+
                    " Casilla: (" +x+", "+y+") con "+dano+" de dano.");
            hiloCliente.writer.writeUTF("ATAQUEEXITOSO");
            hiloCliente.writer.writeUTF(enemigoE);
            hiloCliente.writer.writeUTF("Jugador: " + refPantalla.getTitle()+
                    " Casilla: (" +x+", "+y+") con "+dano+" de dano.");
            AtaquesRecibido.add(enemigoE+" me ataco con "+ ataque+
                    " la casilla ("+x+", "+y+") con "+dano+" de dano.");
        }else{
            System.out.println("No se pudo efectuar el ataque a "+
                    refPantalla.getTitle()+" en la casilla ("+x+", "+y+").");
            hiloCliente.writer.writeUTF("ATAQUENOEXITOSO");
            hiloCliente.writer.writeUTF(enemigoE);
            hiloCliente.writer.writeUTF("No se pudo efectuar el ataque a "+
                    refPantalla.getTitle()+" en la casilla ("+x+", "+y+").");
        }
    }
}
