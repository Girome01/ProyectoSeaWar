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
    private JButton btnImagen;

    public Casillas(JButton ref) {
        this.vida = 100;
        this.tieneVolcan = false;
        this.basuraRadioactiva = false;
        this.btnImagen = ref;
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
    
    public void verVolcan(){
        if(tieneVolcan){
            btnImagen.setBackground(Color.red);
        }
    }
    
    public void verBasura(){
        if(basuraRadioactiva){
            btnImagen.setBackground(Color.cyan);
        }
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
    
    
}
