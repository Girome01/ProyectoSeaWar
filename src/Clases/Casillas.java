/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Gilberth
 */
public class Casillas {
    private int vida;
    private boolean tieneVolcan;
    private boolean basuraRadioactiva;
    private JLabel lblImagen;

    public Casillas(JLabel ref) {
        this.vida = 100;
        this.tieneVolcan = false;
        this.basuraRadioactiva = false;
        this.lblImagen = ref;
    }
    
    public void danarCasilla(int dano){
        if(vida-dano > 0){
            vida -= dano;
        }else
            vida = 0;
        colorLabel();
    }
    
    public void colocarVolcan(){
        tieneVolcan = true;
    }
    
    public void colocarBasuraRadio(){
        basuraRadioactiva = true;
    }
    
    private void colorLabel(){
        if(vida <= 60 && vida > 30)
            lblImagen.setBackground(Color.yellow);
        else if(vida <= 30 && vida > 0)
            lblImagen.setBackground(Color.red);
        else if(vida == 0)
            lblImagen.setBackground(Color.BLACK);
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
