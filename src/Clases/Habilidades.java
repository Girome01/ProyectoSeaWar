/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Gilberth
 */
public abstract class Habilidades{
    private String attack1;
    private String attack2;
    private String attack3;
    Casillas[][] casillas;

    Habilidades(String attack1, String attack2, String attack3,Casillas[][] casillas) {
        this.attack1 = attack1;
        this.attack2 = attack2;
        this.attack3 = attack3;
        this.casillas = casillas;
    }
    
    public void seleccionarAttack(String _attack){
        if(attack1 == _attack.toUpperCase()){
            attack1();
        }else if(attack2 == _attack.toUpperCase()){
            attack2();
        }else if(attack3 == _attack.toUpperCase()){
            attack3();
        }
    }
    
    abstract void attack1();
    abstract void attack2();
    abstract void attack3();
}
