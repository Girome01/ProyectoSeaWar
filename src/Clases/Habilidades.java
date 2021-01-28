/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Cliente.Cliente;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilberth
 */
public abstract class Habilidades{
    private String attack1;
    private String attack2;
    private String attack3;
    public Cliente refCliente;
    Random random = new Random();
    public Luchador refPersonaje;

    Habilidades(String attack1, String attack2, String attack3,Cliente refCliente,Luchador refPersonaje) {
        this.attack1 = attack1;
        this.attack2 = attack2;
        this.attack3 = attack3;
        this.refCliente = refCliente;
        this.refPersonaje = refPersonaje;
    }
    
    public void seleccionarAttack(String _attack,String enemigo){
        if(attack1 == _attack.toUpperCase()){
            attack1( enemigo);
        }else if(attack2 == _attack.toUpperCase()){
            attack2( enemigo);
        }else if(attack3 == _attack.toUpperCase()){
            attack3( enemigo);
        }
    }
    
    abstract void attack1(String enemigo);
    abstract void attack2(String enemigo);
    abstract void attack3(String enemigo);
    
    public void atacarEnemigo(int x, int y, String atacante,String enemigo,double dano, String tipoAtaque) throws IOException{
        refCliente.hiloCliente.writer.writeUTF("ATACAR");
        refCliente.hiloCliente.writer.writeUTF(enemigo);
        refCliente.hiloCliente.writer.writeInt(x);
        refCliente.hiloCliente.writer.writeInt(y); 
        refCliente.hiloCliente.writer.writeDouble(dano);
        refCliente.hiloCliente.writer.writeUTF(atacante);
        refCliente.hiloCliente.writer.writeUTF(tipoAtaque);
    }
    
    public void ataqueArea(int x, int y, int cant, String enemigo,double dano,String tipoAtaque) throws IOException{
        int x1 = x, x2 = x, y1 = y, y2 = y;
        for(int i = 1; i <= cant*refPersonaje.multilpicador;i++){
            x1 += 1;
            x2 -= 1;
            y1 = y;
            y2 = y;
            if( x1 > 0|| x1 < 20 && y > 0 || y < 30)
                //casillas[x1][y].danarCasilla(100);
                atacarEnemigo(x1, y, refCliente.refPantalla.getTitle(), enemigo, dano,tipoAtaque);
            if( x2 > 0|| x2 < 20 && y > 0 || y < 30)
                //casillas[x2][y].danarCasilla(100);
                atacarEnemigo(x2, y, refCliente.refPantalla.getTitle(), enemigo, dano, tipoAtaque);
            for(int j = 1; j <= cant*refPersonaje.multilpicador;j++){
                y1 -= 1;
                if( x > 0|| x < 20 && y1 > 0 || y1 < 30)
                    //casillas[x][y1].danarCasilla(100);
                    atacarEnemigo(x, y1, refCliente.refPantalla.getTitle(), enemigo, dano, tipoAtaque);
                if( x1 > 0|| x1 < 20 && y1 > 0 || y1 < 30)
                    //casillas[x1][y1].danarCasilla(100);
                    atacarEnemigo(x1, y1, refCliente.refPantalla.getTitle(), enemigo, dano, tipoAtaque);
                if( x2 > 0|| x2 < 20 && y1 > 0 || y1 < 30)
                    //casillas[x2][y1].danarCasilla(100);
                    atacarEnemigo(x2, y1, refCliente.refPantalla.getTitle(), enemigo, dano, tipoAtaque);
                y2 += 1;
                if( x1 > 0|| x1 < 20 && y2 > 0 || y2 < 30)
                    //casillas[x1][y2].danarCasilla(100);
                    atacarEnemigo(x1, y2, refCliente.refPantalla.getTitle(), enemigo, dano, tipoAtaque);
                if( x1 > 0|| x1 < 20 && y2 > 0 || y2 < 30)
                    //casillas[x][y2].danarCasilla(100);
                    atacarEnemigo(x, y2, refCliente.refPantalla.getTitle(), enemigo, dano, tipoAtaque);
                if( x2 > 0|| x2 < 20 && y2 > 0 || y2 < 30)
                    //casillas[x2][y2].danarCasilla(100);
                    atacarEnemigo(x2, y2, refCliente.refPantalla.getTitle(), enemigo, dano, tipoAtaque);
            }
        }
    }
    
    public void atArriba(String enemigo, double dano,int x, int y,String tipoAtaque){
        int cantidad = random.nextInt(3)+1;
        for(int i = 0; i < cantidad*refPersonaje.multilpicador; i++){
            y -= 1;
            if( x > 0|| x < 20 && y > 0 || y < 30)
                try {
                    //casillas[x][y].danarCasilla(100);
                    atacarEnemigo(x, y, refCliente.refPantalla.getTitle(), enemigo, dano, tipoAtaque);
                } catch (IOException ex) {
                    Logger.getLogger(PoseidonTrident.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    public void atAbajo(String enemigo, double dano, int x, int y,String tipoAtaque){
        int cantidad = random.nextInt(3)+1;
        for(int i = 0; i < cantidad*refPersonaje.multilpicador; i++){
            y += 1;
            if( x > 0|| x < 20 && y > 0 || y < 30)
                //casillas[x][y].danarCasilla(100);
                try {
                    //casillas[x][y].danarCasilla(100);
                    atacarEnemigo(x, y, refCliente.refPantalla.getTitle(), enemigo, dano, tipoAtaque);
                } catch (IOException ex) {
                    Logger.getLogger(PoseidonTrident.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    public void atDerecha(String enemigo, double dano, int x, int y,String tipoAtaque){
        int cantidad = random.nextInt(3)+1;
        for(int i = 0; i < cantidad*refPersonaje.multilpicador; i++){
            x += 1;
            if( x > 0|| x < 20 && y > 0 || y < 30)
                //casillas[x][y].danarCasilla(100);
                try {
                    //casillas[x][y].danarCasilla(100);
                    atacarEnemigo(x, y, refCliente.refPantalla.getTitle(), enemigo, dano, tipoAtaque);
                } catch (IOException ex) {
                    Logger.getLogger(PoseidonTrident.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    public void atIzquierda(String enemigo, double dano, int x, int y,String tipoAtaque){
        int cantidad = random.nextInt(3)+1;
        for(int i = 0; i < cantidad*refPersonaje.multilpicador; i++){
            x -= 1;
            if( x > 0|| x < 20 && y > 0 || y < 30)
                //casillas[x][y].danarCasilla(100);
                try {
                    //casillas[x][y].danarCasilla(100);
                    atacarEnemigo(x, y, refCliente.refPantalla.getTitle(), enemigo, dano, tipoAtaque);
                } catch (IOException ex) {
                    Logger.getLogger(PoseidonTrident.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
}
