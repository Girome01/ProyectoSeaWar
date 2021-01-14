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
    int TipoAtaque = 0;
    int Vida;
    int TipoResistencia = 0;
    int ResistenciaActiva = 0;
    
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
    
    private int PosicionArray(String Comando){
        
        /*for (int i = 0; i < Ataques.leght; i++) {
            if(Ataques.get(i).nombre.equals(Comando)){
                return i;
            }
        }*/
        return 100;
    }
    
    public void Atacar(String Comando){
        int PosicionAtaque = PosicionArray(Comando);
        int PoderAtaque = 0;
        if(PosicionAtaque != 100){
            if(TipoAtaque == 0){
                //PoderAtaque = Ataques[PosicionAtaque]
                //funcion AtacarAux
            }
            else if(TipoAtaque == 1){
                //PoderAtaque = Ataques[PosicionAtaque] + Poder;
                //funcionAtacarAux
            } 
        }
        else{
            System.out.println("El comando no existe ");
        }
        
    }
    
    public void Sanidad(){
        Vida = Sanidad;
    }
    
    public void Resistencia(){
        ResistenciaActiva = Resistencia;
    }
    
    public void RecibirAtaque(int Daño){
        ResistenciaActiva = ResistenciaActiva - Daño;
        
        if(ResistenciaActiva < 0){
            Vida = Vida - ResistenciaActiva;
        }
        
        ResistenciaActiva = 0;
    }
    
}
