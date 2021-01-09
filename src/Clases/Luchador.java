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
}
