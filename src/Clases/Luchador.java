/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Cliente.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class Luchador {
    String Nombre;
    String UrlImagenes;
    int PorcentajePoblacion; 
    ArrayList<Habilidades> ataques = new ArrayList<Habilidades>();
    Cliente refCliente;
    int Poder;
    int Resistencia;
    int Sanidad;
    int Vida;
    
    Luchador(){
        
    }
    
    public Luchador(String _Nombre, String Url, int _PorcentajePoblacion, int _Poder, int _Resistencia, int _Sanidad, String Ataque, Cliente cliente){
        Nombre = _Nombre;
        UrlImagenes = Url;
        PorcentajePoblacion = _PorcentajePoblacion;
        Poder = _Poder;
        Resistencia = _Resistencia;
        Sanidad = _Sanidad;
        refCliente = cliente;
        FabricaHabilidades ataque = new FabricaHabilidades(refCliente);
        ataques.add(ataque.createHablidad(Ataque));
    }

    public String getNombre() {
        return Nombre;
    }

    public Double getPoder() {
        Double PoderReturn = 0.0;
        if(Poder == 50){
            PoderReturn = 1.5;
        }
        else if(Poder == 75){
            PoderReturn = 1.75;
        }
        else if(Poder == 100){
            PoderReturn = 2.0;
        }
        return PoderReturn;
    }

    public Double getResistencia() {
        Double ResistenciaReturn = 0.0;
        if(Resistencia == 50){
            ResistenciaReturn = 1.5;
        }
        else if(Resistencia == 75){
            ResistenciaReturn = 1.75;
        }
        else if(Resistencia == 100){
            ResistenciaReturn = 2.0;
        }
        return ResistenciaReturn;
        
    }

    public void Sanidad(){
        Vida = Sanidad;
    }
 
    
}
