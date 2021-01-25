/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author Gilberth
 */
public class Casillas {
    private int vida;
    private boolean tieneVolcan;
    private boolean basuraRadioactiva;
    private boolean remolino;
    private JButton btnImagen;
    public String datosAtaque;

    public Casillas(JButton ref) {
        this.vida = 100;
        this.tieneVolcan = false;
        this.basuraRadioactiva = false;
        this.remolino = false;
        this.btnImagen = ref;
        this.datosAtaque = "";
    }
    
    public void danarCasilla(int dano){
        if(vida-dano > 0){
            vida -= dano;
        }else
            vida = 0;
    }
    
    public void colocarVolcan(){
        tieneVolcan = true;
    }
    
    public void colocarBasuraRadio(){
        basuraRadioactiva = true;
    }
    
    public void colocarRemolino(){
        remolino = true;
    }
    
    private boolean verVolcan(){
        if(tieneVolcan){
            btnImagen.setBackground(Color.red);
            return true;
        }
        return false;
    }
    
    private boolean verBasura(){
        if(basuraRadioactiva){
            btnImagen.setBackground(Color.cyan);
            return true;
        }
        return false;
    }
    
    private boolean verRemolino(){
         if(remolino){
            btnImagen.setBackground(Color.white);
            return true;
        }
        return false;
    }

    public int getVida() {
        return vida;
    }

    public boolean isTieneVolcan() {
        return tieneVolcan;
    }

    public boolean isBasuraRadioactiva() {
        return basuraRadioactiva;
    }

    public boolean isRemolino() {
        return remolino;
    }
    
    public void pintarCasilla(){
        if(vida > 0){
            btnImagen.setBackground(Color.GREEN);
        }else{
            btnImagen.setBackground(Color.BLACK);
        }
    }
    
    public void recibirDatAtaque(String ataque){
        datosAtaque += ataque+"\n";
    }
    
    public String datosCasilla(){
        String datos = "Vida: "+vida+". ";
        if(tieneVolcan){
            datos += "Tiene volcan. ";
        }
        if(basuraRadioactiva){
            datos += "Tiene basura radioactiva. ";
        }
        if(remolino){
            datos += "Tiene un remolino. ";
        }
        return datos + datosAtaque+"\n";
    }
    
    public void ocupoada(){
        if( !verBasura() && !verRemolino() && !verVolcan()){
            btnImagen.setBackground(Color.BLUE);
        }
    }
    
    public boolean estaViva(){
        if(vida > 0){
            return true;
        }
        return false;
    }
}
