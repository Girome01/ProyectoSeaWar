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
    public int cantidadPersonajes = 1;
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
        int porcentaje = (_PorcentajePoblacion*600)/100;
        
        if(cantidadPersonajes == 2){
            refPantalla.setMaximoP1(porcentaje);
        }
        else  if(cantidadPersonajes == 3){
            refPantalla.setMaximoP2(porcentaje);
        }
        else  if(cantidadPersonajes == 4){
            refPantalla.setMaximoP3(porcentaje);
            refPantalla.RepartirTropas(personajes.get(0), personajes.get(1), personajes.get(2));
        }
        
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
    
    public void ResetPersonaje(){
        for (int i = 0; i < personajes.size(); i++) {
            if(personajes.get(i).PoderActivado == true){
                personajes.get(i).PoderActivado = false;
            }
            else{
                personajes.get(i).setMultilpicador(1);
            }
            
            personajes.get(i).setResetResistencia(0);
        }
    }
    
    public String obtenerInfo(){
        return refPantalla.getTitle()+" Porcentaje de casillas vivas: "+obtenerPor()+
                "Casillas muertas totales: "+casillasMuertas();
    }
}
