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
    int multilpicador = 1;
    int ResetResistencia = 0;
    public boolean PoderActivado = false;

    
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
        FabricaHabilidades ataque = new FabricaHabilidades(refCliente,this);
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

    public int getSanidad() {
        return Sanidad;
    }

    public void ActivarResistencia(){
        ResetResistencia = Resistencia;
    }
    
    public void ActivarPoder(){
        multilpicador = Poder;
        PoderActivado = true;
    }

    public int getMultilpicador() {
        return multilpicador;
    }

    public int getResetResistencia() {
        return ResetResistencia;
    }

    public void setMultilpicador(int multilpicador) {
        this.multilpicador = multilpicador;
    }

    public void setResetResistencia(int ResetResistencia) {
        this.ResetResistencia = ResetResistencia;
    }

    public boolean Ataque(String ataque,String SubAtaque, String nombre,ArrayList posiciones){
        boolean resultado = false;
        
        System.out.println("Entro a Ataque");
        for (int i = 0; i < ataques.size(); i++) {
            Habilidades refhabilidad = ataques.get(i);
            System.out.println(refhabilidad.nombre);
            System.out.println(ataque);
            if(ataque.equals(refhabilidad.nombre)){
                refhabilidad.seleccionarAttack(SubAtaque, nombre, posiciones);
                resultado = true;
                System.out.println("Ataque: " + ataque);
                System.out.println("Subataque: " + SubAtaque);
                System.out.println("nombre: " + nombre);
            }
            else{
                System.out.println("NO encontre el ataque");
            }
            
        }
        return resultado;
    }
 
    
}
