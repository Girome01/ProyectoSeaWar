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
            refPantalla.ActualizarDatos();
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
    
    public void recibirdano(int x, int y, double dano, String enemigoE,String ataque) throws IOException{
        if(refPantalla.casillas[x][y].estaViva()){
            refPantalla.casillas[x][y].danarCasilla(dano); //Multiplicarlo por resistencia
            refPantalla.casillas[x][y].recibirDatAtaque("El enemigo"+enemigoE+" ataco con "+
                    ataque+" causando "+ dano+" de dano."); // multiplicarlo por resistencia
            AtaquesRecibido.add("El enemigo"+enemigoE+" ataco con "+
                    ataque+" causando "+ dano+" de dano.");
            hiloCliente.writer.writeUTF("ATAQUEEXITOSO");
            hiloCliente.writer.writeUTF(enemigoE);
            hiloCliente.writer.writeUTF("Jugador: " + refPantalla.getTitle()+
                    " Casilla: (" +x+", "+y+") con "+dano+" de dano.");
            AtaquesRecibido.add(enemigoE+" me ataco con "+ ataque+
                    " la casilla ("+x+", "+y+") con "+dano+" de dano.");
            refPantalla.ActualizarDatos();
        }else{
            System.out.println("No se pudo efectuar el ataque a "+
                    refPantalla.getTitle()+" en la casilla ("+x+", "+y+").");
            hiloCliente.writer.writeUTF("ATAQUENOEXITOSO");
            hiloCliente.writer.writeUTF(enemigoE);
            hiloCliente.writer.writeUTF("No se pudo efectuar el ataque a "+
                    refPantalla.getTitle()+" en la casilla ("+x+", "+y+").");
        }
    }
    
    public void recibirDanoVolcan(int x, int y, double dano,String enemigoE,int casillas) throws IOException{
        String ataque = "VOLCANORAISING";
        System.out.println("RecibirDanoVolcano");
        System.out.println("X" + x);
        System.out.println("Y" + y);
        System.out.println("Dano" + dano);
        System.out.println("EnemigoE" + enemigoE);
        System.out.println("Ataque" + ataque);
        System.out.println("Casillas" + casillas);
        for (int x1 = x; x1 <x+casillas; x1++) {
            for (int y1 = y; y1 < y+casillas; y1++) {

                if( x1 < 20 && y1 < 30){
                    System.out.println("x:" + x1 );
                    System.out.println("y:" + y1 );
                    if(refPantalla.casillas[x1][y1].estaViva()){
                        System.out.println("Entre a atacar");
                    refPantalla.casillas[x1][y1].setTieneVolcan(true);
                    refPantalla.casillas[x1][y1].danarCasilla(dano);
                    refPantalla.casillas[x1][y1].recibirDatAtaque("El enemigo"+enemigoE+" ataco con "+
                        ataque+" causando "+ dano+" de dano."); // multiplicarlo por resistencia
                    AtaquesRecibido.add("El enemigo"+enemigoE+" ataco con "+
                        ataque+" causando "+ dano+" de dano.");
                    hiloCliente.writer.writeUTF("ATAQUEEXITOSO");
                    hiloCliente.writer.writeUTF(enemigoE);
                    hiloCliente.writer.writeUTF("Jugador: " + refPantalla.getTitle()+
                    " Casilla: (" +x1+", "+y1+") con "+dano+" de dano.");
                    AtaquesRecibido.add(enemigoE+" me ataco con "+ ataque+
                    " la casilla ("+x1+", "+y1+") con "+dano+" de dano.");
                    }else{
                        System.out.println("No se pudo efectuar el ataque a "+
                        refPantalla.getTitle()+" en la casilla ("+x1+", "+y1+").");
                        hiloCliente.writer.writeUTF("ATAQUENOEXITOSO");
                        hiloCliente.writer.writeUTF(enemigoE);
                        hiloCliente.writer.writeUTF("No se pudo efectuar el ataque a "+
                        refPantalla.getTitle()+" en la casilla ("+x1+", "+y1+").");
                        }
                    
                    }else{
                    System.out.println("X y Y malo");
                }
                    
                }
                
                
            }
            
        }
        
    
}
