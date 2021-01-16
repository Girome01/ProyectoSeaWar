/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Luis
 */
public class Luchador {
    String Nombre;
    String UrlImagenes;
    int PorcentajePoblacion; 
    //Factory ataques
    int Poder;
    int Resistencia;
    int Sanidad;
    int Vida;
    
    Luchador(){
        
    }
    
    Luchador(String _Nombre, String Url, int _PorcentajePoblacion, int _Poder, int _Resistencia, int _Sanidad){
        Nombre = _Nombre;
        UrlImagenes = Url;
        PorcentajePoblacion = _PorcentajePoblacion;
        Poder = _Poder;
        Resistencia = _Resistencia;
        Sanidad = _Sanidad;
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
